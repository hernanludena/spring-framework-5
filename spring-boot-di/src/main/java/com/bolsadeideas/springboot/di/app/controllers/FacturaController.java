package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;

@Controller  //Contexto o scope Singleton por defecto, dura toda la aplicacion
@RequestMapping("/factura")
public class FacturaController {
	
	@Autowired
	private Factura factura;
	
	@GetMapping("/ver")
	public String ver(Model model) {  //-->pasamos a la vista los objetos factura y titulo
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Ejemplo Factura con inyección de dependencia");
		return "factura/ver";
	}

}

//http://localhost:8080/factura/ver

//Contexto o scope Singleton
//Con este scope no se debe guardar atributos de usuario en el controlador, porque pueden ser modificados por otras usuarios o petciones
//Es ideal insertar objeto stateless (sin estado), que no menatenga valores en los atributos como una sesion o carro de compras, es preferible usar objetos con conexto/scope session