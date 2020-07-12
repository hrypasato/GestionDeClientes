package com.example.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	//Consulta un cliente dado su email
	Optional<Cliente> findByEmail(String email);
}
