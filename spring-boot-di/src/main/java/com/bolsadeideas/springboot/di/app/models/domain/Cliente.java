package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope  //Por defecto es singleton, pero se cambia a Request
public class Cliente {

	@Value("${cliente.nombre}")//inyectar de archivo de recursos
	private String nombre;

	@Value("${cliente.apellido}")
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}

//Singleton
//RequestScope
//SessionScope: carro de compras, sesion http. EL objeto dura lo que dura una sesion, cuando se cierra el navegador. Usa sesiones http
//AplicationScope: por parecido al singleton, se guarda en el contexto servletContext y no el aplicationContext