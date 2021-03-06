package com.bolsadeideas.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario); //objeto por defecto
		return "form";
	}
	
	//@Valid validaciones java para el objeto Usuario
	//BindingResult almacena errores de validacion en objeto
	@PostMapping("/form")
	//public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model) {/
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			
			//FieldErrors> lista de errores
			result.getFieldErrors().forEach(err ->{  //expresion lambda
				//campo + mensaje
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			return "form";
		}
		
		model.addAttribute("usuario", usuario);

		return "resultado";
	}

}
