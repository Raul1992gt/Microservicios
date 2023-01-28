package com.edx.microservicios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edx.microservicios.models.Pedido;
import com.edx.microservicios.repositories.PedidoRepository;

public interface PedidoService {

	List<Pedido> pedidoPorComercial(int idComercial);
	
}
