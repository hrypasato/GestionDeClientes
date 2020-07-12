package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long>{
	//Encuetra todas las direcciones asociadas a un cliente 
	List<Ubicacion> findByCliente(Cliente cliente);
}
