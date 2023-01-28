package com.edx.microservicios.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.edx.microservicios.models.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{
	
	@Query("Select distinct c from Comercial c, Pedido p where p.comercial.id = c and p.cliente.id =?1")
	public Optional<Comercial> findAllByCliente(int id);
	@Query("Select distinct c from Comercial c, Pedido p where p.comercial.id = c")
	public List<Comercial> buscarConPedido();
}