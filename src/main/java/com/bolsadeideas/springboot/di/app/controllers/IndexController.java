package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;


@Controller
public class IndexController {
	
	//Autowired se puede pasar tanto el atributo, constructor o setter
	@Autowired
	//@Qualifier("miServicioPrincipal") // @Qualifier -> nos permite selecionar atraves del nombre
	private IServicio servicio;
	
	//@Autowired //para injectar un objeto que esta registrado en el contendor de spring
	//public IndexController(IServicio servicio) { // los constructores de forma automatica inyecta @Autowired
	//	super();
	//	this.servicio = servicio;
	//}



	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

	//@Autowired
	//public void setServicio(IServicio servicio) {
	//	this.servicio = servicio;
	//}
	
	


	
	
	
}
