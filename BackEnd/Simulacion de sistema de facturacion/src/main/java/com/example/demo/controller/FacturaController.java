package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Factura;
import com.example.demo.repositorio.FacturaRepositorio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class FacturaController {
	private final String LIST_SAVED = "Facturas guardadas";
	
	@Autowired
	FacturaRepositorio repositorio;
	
	@GetMapping("/listar")
	public ResponseEntity<?> getAllFacturas() {
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/cliente")
	public ResponseEntity<?> getFacturasByCliente(@RequestParam(value="id") Long id) {
        
		return ResponseEntity.ok(repositorio.findByIdCliente(id));
        
	}
}
