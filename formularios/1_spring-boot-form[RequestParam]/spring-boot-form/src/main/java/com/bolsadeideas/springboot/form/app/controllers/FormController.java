package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {
	
	//Metodos handler para pasar datos a la vista y mostrar el formulario
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario usuarios");
		return "form";
	}
	
	//Metodos handler para procesar datos, recibir datos del formulario
	@PostMapping("/form")
	public String procesar(Model model, 
			@RequestParam(name="username") String username,
			@RequestParam String password,
			@RequestParam String email) {
		
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);

		
		return "resultado";
	}

	/**
	 * Las parametros se van a mapear automaticamente el objeto Usuario
	 * solo por tener los mismos nombres en la vista (set y get)
	 * queda mucho mas limpio y automatizado
	 * 
	 * @PostMapping("/form")
	public String procesar(Usuario usuario, Model model) {
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);
		
		return "resultado";
	}
	 * 
	 * 
	 */
	
}
