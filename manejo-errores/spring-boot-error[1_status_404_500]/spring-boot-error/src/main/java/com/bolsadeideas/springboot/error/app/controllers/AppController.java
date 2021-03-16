package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		Integer valor = 100/0;
		// Integer valor = Integer.parseInt("10xaaa");
		return "index";
	} //Error 500: Internal Server Error, no existe la plantilla, by zero
	//Error: 404 no existe recurso, no existe la pagina, la ruta
}


//Pon convencion se crea la ruta /error/ y las paginas 404.html, 500.html
//http://localhost:8080/index