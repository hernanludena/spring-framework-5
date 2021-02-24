package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//el objeto tiene por defecto el contexto/scope Singleton en el contenedor, vamos a tener una instancia y va durar lo que dura nuestra aplicacion arriba
//es decir va durar hasta que hagamos bajemos el server, un stop
@Component
@RequestScope  //Aqui cambiamos el scope por defecto de Singleton a Request, con requestscope el bean va durar lo que dura una peticion http de usuario
//Cuando se ejecute cad usuario tendra una factura propia
public class Factura implements Serializable{   

	//Se debe implentar la interfaz serializable, para que convierta en bytes y se pueda guardar en sesion http
	private static final long serialVersionUID = 946004357128146951L;

	@Value("${factura.descripcion}")  //Inyeccion de recurso  de archivos properties: Factura Deporte
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired   //inyectamos la  lista
	private List<ItemFactura> items;
	
	
	//Podemos implementar tareas previas o despues de la construccion del componente/objeto
	
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("José"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));  //Saldra en el terminal cuando hagamos un stop al server
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
