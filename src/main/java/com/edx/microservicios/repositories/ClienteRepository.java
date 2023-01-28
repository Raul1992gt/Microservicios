package com.edx.microservicios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edx.microservicios.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
