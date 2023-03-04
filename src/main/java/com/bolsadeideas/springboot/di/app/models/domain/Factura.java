package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.ApplicationScope;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope // para que no sea singleton, ahora esta factura(bean) va a durar lo que dura una peticion HTTP usuario cada usauario que se conecte va a tener una factura distinta y propia
//@SessionScope // se usa para marcar nuestro objeto como de session por ej carro de compras o con un sistema de autoticacacion, el alcance del objeto es lo que dura una session cuando se inicia desde que se crea este componente en el contenedor de tipo session y se va a detruir cuando cerremos el navegador 
//@ApplicationScope // similar al singleton, pero se diferencia que es un singleton que se guarda en el contexto servlet y no en el application context de spring
public class Factura implements Serializable{ // serializable es importante para el @SessionScope
	private static final long serialVersionUID = 946004357128146951L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	//@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct // ciclo de vida: cuando se crea
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Ezequiel"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy // ciclo de vida: cuando se destruye
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
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
