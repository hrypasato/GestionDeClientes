package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Factura;

public interface FacturaRepositorio extends MongoRepository<Factura, String>{
	List<Factura> findByIdCliente(Long idCliente);
}
