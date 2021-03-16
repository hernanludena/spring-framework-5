package com.bolsadeideas.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//si es POST se omite interceptor, solo aplica a los GET
		if(request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("es un método del controlador: " + metodo.getMethod().getName());
		}

		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando ...");
		logger.info("Interceptando: " + handler);
		long tiempoInicio = System.currentTimeMillis(); //tiempo actual en milisegundos
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		//Emular una demora/delay con Thread, simular una carga en el RQ
		Random random = new Random();
		Integer demora = random.nextInt(100); //tiempo aleatorio entre 0 y 99 milisegundos
		Thread.sleep(demora);
		
		//response.sendRedirect(request.getContextPath()).concat("/login"); return false; //Podemos redireccionar 
		return true; //para que continue con el RQ
	}

	//luego de ejecutar el metodo de controlador ejecuta el postHandler
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		
		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio"); //Covert de Object to long
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		//se controla para que las rutas de los recursos de estaticos, imagenes, estilos css, resources no se intercepten
		if(handler instanceof HandlerMethod && modelAndView != null) { //HandlerMethod del controlador (validacion mas estricta)
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido); //pasamos a la vista para poder inprimirlo en nuestra plantilla
		}
		logger.info("Tiempo Transcurrido: " + tiempoTranscurrido + " milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo ...");

	}

	
}
