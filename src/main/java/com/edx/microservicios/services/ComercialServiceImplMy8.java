package com.edx.microservicios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edx.microservicios.models.Comercial;
import com.edx.microservicios.repositories.ComercialRepository;

@Service
public class ComercialServiceImplMy8 implements ComercialService{


	//Para poder hacer uso del repositorio le instanciamos con la anotación @Autowired
	@Autowired
	private ComercialRepository crep;

	@Override
	// Nuevo comercial
	public Comercial altaComercial(Comercial comercial) {
		return crep.save(comercial);
	}

	@Override
	// Eliminar comercial
	public boolean eliminarComercial(int id) {
		try {
			crep.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

	@Override
	// Buscar comercial por id 
	public Optional<Comercial> findById(int id) {
		return crep.findById(id);
	}

	@Override
	// Mostrar todos 
	public List<Comercial> findAll() {
		return crep.findAll();
	}

	@Override
	public Optional<Comercial> buscarComercialPorCliente(int idCliente) {
		return crep.findAllByCliente(idCliente);
	}

	@Override
	public List<Comercial> buscarConPedido() {
		return crep.buscarConPedido();
	}

	


}
