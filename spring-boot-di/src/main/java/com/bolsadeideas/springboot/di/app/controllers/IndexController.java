package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	//Sin inyeccion de dependencias
	//private MiServicio servicio = new MiServicio(); 
	
	//Con inyeccion de dependencias
	//para desacoplar los objetos de logica de negocio, se usa interfaces
	@Autowired  //busca un objeto en el contenedor de spring y lo crea
	@Qualifier("miServicioComplejo")//inyectarf a traves del nombre del componente especifico	
	private IServicio servicio;

	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}
	
	/*Inyeccion por controlador
	
	@Autowired  -- tambien puede ir de forma implicita.
    private IServicio servicio;

	public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}
	 */
	
	
}
