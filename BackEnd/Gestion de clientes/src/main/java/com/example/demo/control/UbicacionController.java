package com.example.demo.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Ubicacion;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.UbicacionRepository;

@RestController
@RequestMapping("/ubicacion")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UbicacionController {
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@GetMapping(value = "/listar")//lista todas la ubicaciones diponibles
	public  ResponseEntity<?> getUbicaciones(){
		return ResponseEntity.ok(ubicacionRepository.findAll());
	}
	
    @GetMapping//retorna una ubicacion dada su ID
    public ResponseEntity<?> getUbicacion(@RequestParam(value="id") Long id) {
        Optional<Ubicacion> foundBucketList = ubicacionRepository.findById(id);

        if(foundBucketList.isPresent()){
            return ResponseEntity.ok(foundBucketList.get());
        }else {
            return ResponseEntity.badRequest().body("Ubicacion no encotrada");
        }
    }
	
	@GetMapping("/cliente")//Consulta las direcciones que tiene un cliente
	public ResponseEntity<?> getCalificacionByCliente(@RequestParam(value="id") Long id) {
        Optional<Cliente> foundCliente = clienteRepository.findById(id);

        if(foundCliente.isPresent()){//Retorna una lista de direcciones
            return ResponseEntity.ok(ubicacionRepository.findByCliente(foundCliente.get()));
        }else {
            return ResponseEntity.badRequest().body(ClienteControler.CLIENTE_NOT_FOUND);
        }
	}	
    
    
	@PostMapping//Almacena una nueva ubicacion
	public ResponseEntity<?> crearUbicacion(@RequestBody Ubicacion ubicacion, 
			@RequestParam(value= "cliente") Long idCliente ) {
		
		ubicacion.setCliente(clienteRepository.findById(idCliente).get());
		return ResponseEntity.ok(ubicacionRepository.save(ubicacion));
	}
	
    @DeleteMapping//Elimina ubicacion dado su ID
    public ResponseEntity<?> removeUbicacion(@RequestParam(value="id") Long id) {
        ubicacionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
}
