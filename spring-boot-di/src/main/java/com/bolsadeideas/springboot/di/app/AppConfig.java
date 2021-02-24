package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

//Esta clase tambien nos permite registrar beans en el contenedor
@Configuration
public class AppConfig {
	
	//Estos metodos vendrian sera Beans devueltos.
	
	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	//@Bean("default") 
	@Bean("itemsFactura") //registramos objeto itemsFactura
	public List<ItemFactura> registrarItems(){ //NO importa este nombre, busca un metodo que devuelva el objeto List<ItemFactura> dentro de spring
		Producto producto1 = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(linea1, linea2); //convertir a lista
	}

	@Bean("itemsFacturaOficina")
	@Primary  //permite que el bean sea elegible y no haya conflicto con el bean anterior
	public List<ItemFactura> registrarItemsOficina(){  //Cuando hay dos beans del tipo List<ItemFactura>, se debe usar Qualifier en la inyeccion 
		Producto producto1 = new Producto("Monitor LG LCD 24", 250);
		Producto producto2 = new Producto("Notebook Asus", 500);
		Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
		Producto producto4 = new Producto("Escritorio Oficina", 300);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 1);
		ItemFactura linea3 = new ItemFactura(producto3, 1);
		ItemFactura linea4 = new ItemFactura(producto4, 1);
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
	
}
