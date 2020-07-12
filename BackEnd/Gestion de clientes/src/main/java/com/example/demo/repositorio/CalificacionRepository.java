package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Calificacion;
import com.example.demo.modelo.Cliente;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{
	//Lista las calificaciones realizadas por un cliente
	List<Calificacion> findByCliente(Cliente cliente);
}
