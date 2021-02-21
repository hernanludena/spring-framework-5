package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		//redirect:redirige a otra pagina desde cero
		//reiniciar el request hacia el controlador
		//return "redirect:/app/index";
		//return "redirect:https://www.google.com";
		
		//forward:sin reiniciar el request, sin recargar la pagina, 
		//va realizar un dispatcher, los parametros del requets se mantienen
		return "forward:/app/index";
	}
}
