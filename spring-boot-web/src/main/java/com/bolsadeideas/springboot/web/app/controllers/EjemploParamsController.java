package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")  //ruta base
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	//http://localhost:8080/params/
	
	//http://localhost:8080/params/string?texto=Hola
	//http://localhost:8080/params/string
	//@RequestParam> permite enviar parametros en la url
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "algún valor...") String texto,
			Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}

	//http://localhost:8080/params/mix-params/?saludo=holaHlu&numero=7
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

	//http://localhost:8080/params/mix-params-request/?saludo=holaHlu&numero=7
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

}
