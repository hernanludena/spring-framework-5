package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")  //ruta base
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//el nombre del metodo es el nombre de la vista que tienen que cargar
	//un controlador puede tener varios metodos, cada metodo maneja una pagina, una peticion hhtp distinta
	//una para listar, una para mostrar el formulario, para guardar datos, editar datos
			
	//path tiene como alias el value
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	//API REST: POST, PUT(update), GET, DELETE
	//un metodo puede tener mapeado varias rutas url
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {  
		model.addAttribute("titulo", textoIndex);
		model.addAttribute("titulo2", "hlu");
		return "index"; //se debe crear plantilla/vista con ese nombre index.html
		//http://localhost:8080/app/home
	}
	
	/**
	 * para pasar datos a la vista se puede usar Model, ModelMap o Map<String,Object>
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Map<String,Object> map) { 
		map.put("titulo", "Hola Spring Framework con Map");		
		return "index"; 
	}
	*/
	
	/**
	 * para pasar datos a la vista tambien se puede usar ModelAndView mv 
	@GetMapping({"/index", "/", "", "/home"})
	public ModelAndView index(ModelAndView mv) { 
		mv.addObject("titulo", "Hola Spring Framework con ModelAndView");		
		mv.setViewName("ïndex");
		return mv; 
	}
		*/
		
	
	@RequestMapping("/perfil")  //sino se coloca por defecto es GET
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil"; //si esta dentro de otro directorio colocamos "carpeta/perfil"
		//no es necesario colocar perfil.html, porque busca todo dentro de template
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios") //permite pasar a ls vista, con nombre usuarios y lo que retorna el metodo se presenta en la vista
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrés", "Guzmán", "andres@correo.com"),
				new Usuario("John", "Doe", "john@correo.com"),
				new Usuario("Jane", "Doe", "jane@correo.com"),
				new Usuario("Tornado", "Roe", "roe@correo.com"));

		return usuarios;
	}

}
