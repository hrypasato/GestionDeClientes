package com.example.demo.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.NoRegistrado;
import com.example.demo.repositorio.NoRegistradoRepository;
/*
 * Interaccion con los clientes que no esta registrados
 * */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class NoRegistradoController {
	
	@Autowired
	NoRegistradoRepository repository;
	
	@GetMapping(value = "/listar")//lista todas las entradas
	public  ResponseEntity<?> getVisitante(){
		return ResponseEntity.ok(repository.findAll());
	}
	
    @GetMapping//Busca un registro dado su id
    public ResponseEntity<?> getVisitante(@RequestParam(value="id") Long id) {
        Optional<NoRegistrado> foundVisitante = repository.findById(id);

        if(foundVisitante.isPresent()){
            return ResponseEntity.ok(foundVisitante.get());
        }else {
            return ResponseEntity.badRequest().body("Objeto no encontrado");
        }
    }
    
    @PostMapping//Almacena un registro
	public ResponseEntity<?> crearVisitante(@RequestBody NoRegistrado noRegistrado) {
		return ResponseEntity.ok(repository.save(noRegistrado));
	}
	
    @PutMapping//Actualiza un registro
    public ResponseEntity<?> updateVisitante(@RequestBody NoRegistrado noRegistrado) {
       return ResponseEntity.ok(repository.save(noRegistrado));
    }
    
    @DeleteMapping//Elimina un registro
    public ResponseEntity<?> removeVisitante(@RequestParam(value="id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
