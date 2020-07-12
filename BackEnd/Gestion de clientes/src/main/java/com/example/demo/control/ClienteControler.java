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

import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.ClienteRepository;
/*
 * Interactua con los clientes registrados en el sistema
 * */
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ClienteControler {
	public static final String CLIENTE_NOT_FOUND="Cliente no encontrado";
	
	@Autowired
	ClienteRepository repository;
	
	@GetMapping(value = "/listar")//Lista todos los clientes registrados
	public  ResponseEntity<?> getClientes(){
		return ResponseEntity.ok(repository.findAll());
	}
	
    @GetMapping//Retorna un clinete dado su ID
    public ResponseEntity<?> getCliente(@RequestParam(value="id") Long id) {
        Optional<Cliente> foundCliente = repository.findById(id);

        if(foundCliente.isPresent()){
            return ResponseEntity.ok(foundCliente.get());
        }else {
            return ResponseEntity.badRequest().body(CLIENTE_NOT_FOUND);
        }
    }
	
	
    @GetMapping(value = "/login")//Consulta para iniciar sesion con un cliente
    public ResponseEntity<?> loginCliente(@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
    	 Optional<Cliente> foundCliente = repository.findByEmail(email);
    	 
    	 if(foundCliente.isPresent()) {
    		 Cliente cliente = foundCliente.get();
    		 //Comprueba que las contrasenias sean iguales
    		 if(cliente.getPassword().equals(password)) {
    			 return ResponseEntity.ok(cliente);
    		 }
    	 }
    	
    	 return ResponseEntity.badRequest().body(CLIENTE_NOT_FOUND);
    	
    }
    
    @PostMapping//Almacena un nuevo cliente
	public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(repository.save(cliente));
	}
	
    @PutMapping//Actualiza un cliente
    public ResponseEntity<?> updateBucketList(@RequestBody Cliente cliente) {
       return ResponseEntity.ok(repository.save(cliente));
    }
    
    @DeleteMapping//Elimina un cliente
    public ResponseEntity<?> removeCliente(@RequestParam(value="id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
