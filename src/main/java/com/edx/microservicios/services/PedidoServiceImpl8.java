package com.edx.microservicios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edx.microservicios.models.Pedido;
import com.edx.microservicios.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl8 implements PedidoService{

	@Autowired
	private PedidoRepository pRep;

	@Override
	public List<Pedido> pedidoPorComercial(int idComercial) {
		return pRep.buscarComercialConPedido(idComercial);
	}
	
	
}
