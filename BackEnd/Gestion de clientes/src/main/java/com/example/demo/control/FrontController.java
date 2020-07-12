package com.example.demo.control;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Carrito;
/*
 * Simula una peticion desde el sistema de gestion de clientes hacia el 
 * sistema de interfaza de usuario.
 * */
@RestController
@RequestMapping("/interfaz")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class FrontController {
	@GetMapping
	public ResponseEntity<?> getIdCarrito() {		
		return ResponseEntity.ok(new Carrito());//Retorna un objeto con una direccion Ip y un idCarrito aleatorios 
	}
}
