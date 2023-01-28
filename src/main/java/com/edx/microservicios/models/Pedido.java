package com.edx.microservicios.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private int id;
	
	@Column(nullable = false)
	private double total;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente",nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_comercial", nullable = false)
	private Comercial comercial;
	
	

	public Pedido() {
	}

	public Pedido(int id, double total, Date fecha, Cliente cliente, Comercial comercial) {
		this.id = id;
		this.total = total;
		this.fecha = fecha;
		this.cliente = cliente;
		this.comercial = comercial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comercial getComercial() {
		return comercial;
	}

	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", total=" + total + ", fecha=" + fecha + ", cliente=" + cliente + ", comercial="
				+ comercial + "]";
	}
	
	
	
}
