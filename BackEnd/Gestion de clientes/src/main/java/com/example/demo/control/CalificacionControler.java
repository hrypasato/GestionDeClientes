package com.example.demo.control;

import java.util.Optional;

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

import com.example.demo.modelo.Calificacion;
import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.CalificacionRepository;
import com.example.demo.repositorio.ClienteRepository;

@RestController
@RequestMapping("/calificacion")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CalificacionControler {
	private final String CALIFICACION_NOT_FOUND = "Calificacion no encontrada";
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CalificacionRepository calificacionRepository;
	
	@GetMapping(value = "/listar") //lista todas las calificaciones almacenadas
	public  ResponseEntity<?> getCalificaciones(){
		return ResponseEntity.ok(calificacionRepository.findAll());
	}
	
	@GetMapping
	public ResponseEntity<?> getCalificacion(@RequestParam(value="id") Long id) {//consulta una calificacion dado su ID
        Optional<Calificacion> foundCalificion = calificacionRepository.findById(id);

        if(foundCalificion.isPresent()){//Comprueba si la calificacion existe en la base de datos
            return ResponseEntity.ok(foundCalificion.get());
        }else {
            return ResponseEntity.badRequest().body(CALIFICACION_NOT_FOUND);
        }
	}
	
	@GetMapping("/cliente")//lista todas las calificaciones de un cliente en especifico usando el id del cliente
	public ResponseEntity<?> getCalificacionByCliente(@RequestParam(value="id") Long id) {
        Optional<Cliente> foundCliente = clienteRepository.findById(id);

        if(foundCliente.isPresent()){
            return ResponseEntity.ok(calificacionRepository.findByCliente(foundCliente.get()));
        }else {
            return ResponseEntity.badRequest().body(ClienteControler.CLIENTE_NOT_FOUND);
        }
	}	
	
	@PostMapping//guarda una nueva calificacion de un cliente
	public ResponseEntity<?> crearDescripcion(@RequestBody Calificacion calificacion, 
			@RequestParam(value ="cliente") Long idCliente) {
		
		calificacion.setCliente(clienteRepository.findById(idCliente).get());
		return ResponseEntity.ok(calificacionRepository.save(calificacion));
	}
	
}
