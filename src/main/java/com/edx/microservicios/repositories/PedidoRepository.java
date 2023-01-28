package com.edx.microservicios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edx.microservicios.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query("Select p from Pedido p where p.comercial.id = ?1")
	public List<Pedido> buscarComercialConPedido(int id);
}
