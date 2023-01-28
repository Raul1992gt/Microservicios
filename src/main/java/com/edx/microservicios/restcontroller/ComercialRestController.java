package com.edx.microservicios.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edx.microservicios.models.Comercial;
import com.edx.microservicios.services.ComercialService;

//La anotación @CrossOrigins(origins=”*”), es para permitir accesos desde aplicaciones cliente web
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comercial")
public class ComercialRestController {
	
	@Autowired
	private ComercialService cserv;
	

	//Mostrar todos los comerciales
	@GetMapping("/all")
	public List<Comercial> mostrarTodos(){
		return cserv.findAll();
	}
	
	//Mostramos el comercial buscado por Id
	@GetMapping("/uno/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") int id) {
		//si el comercial buscado por el id pasado por parametro no existe
		if (!cserv.findById(id).isPresent()) {
			//devolvemos el estado not found (404) y el mensaje que queramos añadir
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comercial no encontrado");
		}
		//devolvemos el estado found (302) y el objeto que buscamos en el body
		return ResponseEntity.status(HttpStatus.FOUND).body(cserv.findById(id));

	}
	 
	
	@PostMapping("/alta")
	public ResponseEntity<?> altaComercial(@RequestBody Comercial comercial) {
		//Devolvemos el estado created 201 y le metemos en el cuerpo el comercial creado
		return ResponseEntity.status(HttpStatus.CREATED).body(cserv.altaComercial(comercial));
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> borrarComercial(@PathVariable("id") int id) { 
		if (!cserv.findById(id).isPresent()) {
			//Si llegamos aquí mandamos not found (404) y el mensaje en el body
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comercial no encontrado");
		}
		//Eliminamos comercial
		cserv.eliminarComercial(id);
		//En este caso devolvemos el status ok (200) y un mensaje en el body
		return ResponseEntity.status(HttpStatus.OK).body("Commercial borrado con éxito");
	}
	@GetMapping("/bycliente/{id}")
	public ResponseEntity<?> buscarPorCliente(@PathVariable("id") int idCliente){
		if(!cserv.findById(idCliente).isPresent()) {
			//Si llegamos aquí mandamos not found (404) y el mensaje en el body
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comercial no encontrado");
		}
		//En este caso devolvemos el status found (302) y un mensaje en el body
		return ResponseEntity.status(HttpStatus.FOUND).body(cserv.buscarComercialPorCliente(idCliente));
	}
	
	@GetMapping("/conpedidos")
	public List<Comercial> buscarConPedidos() {
		return cserv.buscarConPedido();
	}

}
