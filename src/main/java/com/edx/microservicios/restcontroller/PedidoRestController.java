package com.edx.microservicios.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edx.microservicios.models.Pedido;
import com.edx.microservicios.services.PedidoService;

//La anotación @CrossOrigins(origins=”*”), es para permitir accesos desde aplicaciones cliente web
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
	
	@Autowired
	private PedidoService pserv;
	
	@GetMapping("/{id}")
	public List<Pedido> buscarPorComercial(@PathVariable("id") int id){
		return pserv.pedidoPorComercial(id);
	}

}
