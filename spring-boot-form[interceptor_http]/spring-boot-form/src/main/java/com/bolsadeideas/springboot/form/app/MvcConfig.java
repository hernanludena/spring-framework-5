package com.bolsadeideas.springboot.form.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//Clase personalizada de configuracion para registrar inteceptor en el stack de spring
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	//inyectamos mediante la interfaz HandlerInterceptor
	@Autowired
	@Qualifier("tiempoTranscurridoInterceptor")
	private HandlerInterceptor tiempoTranscurridoInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");
		//se agrega lista de rutas, sino se coloca aplica a todas las rutas
	}

}
