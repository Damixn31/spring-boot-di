package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

//@Component("miServicioComplejo") // con esto queda registrado como un beans de spring 
//@Service // para tener logica de negocio se puede usar este o @Component
//@Primary // si tenemos varios bean para que no nos de error, nos permite inyectar por defecto en nuestras clases indicamos cual es la princial
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algun proceso importante complicado...";
	}
}
