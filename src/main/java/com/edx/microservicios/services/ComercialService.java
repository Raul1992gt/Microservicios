package com.edx.microservicios.services;

import java.util.List;
import java.util.Optional;


import com.edx.microservicios.models.Comercial;

public interface ComercialService {

	Comercial altaComercial(Comercial comercial);
	boolean eliminarComercial(int id);
	Optional<Comercial> findById(int id);
	List<Comercial> findAll();
	Optional<Comercial> buscarComercialPorCliente(int idCliente);
	List<Comercial> buscarConPedido();
	
	
	
	
}

