package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import com.bolsadeideas.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {
	
	//Inyectamos Servicio
	@Autowired
	private UsuarioService usuarioService;

	//Generamos excepciones
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		Integer valor = 100/0;
		// Integer valor = Integer.parseInt("10xaaa");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		//Usuario usuario  = usuarioService.obtenerPorId(id);
		
		/*if(usuario==null) { //Podemos lanzar exception
			throw new UsuarioNoEncontradoException(id.toString());
		}*/
		
		//Usando Optional de java 8, usando funcion de lamda
		Usuario usuario  = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}

//http://localhost:8080/ver/1
//http://localhost:8080/ver/67
