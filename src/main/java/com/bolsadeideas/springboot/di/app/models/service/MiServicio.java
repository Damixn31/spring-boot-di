package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component("miServicioSimple") // con esto queda registrado como un beans de spring 
//@Service // para tener logica de negocio se puede usar este o @Component
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algun proceso importante simple...";
	}
}
