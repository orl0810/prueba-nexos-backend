package com.credibanco.assessment.card.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transactions")
public class EntityTransaction {
	
	@Id
	@Column(nullable = false, unique = true)
	@NotNull(message = "La referencia no puede estar vacía")
	private int referencia;
	
	@NotNull(message = "El número de tarjeta no puede estar vacío")
	private long pan;
	
	@NotNull(message = "El valor de compra no puede estar vacío")
	private long totalCompra;
	
	@NotEmpty(message = "La dirección de compra no puede estar vacía")
	private String direccion;
	
    private String fecha;
	
	public EntityTransaction() {
	}
	
	public long getPan() {
		return pan;
	}
	public void setPan(long pan) {
		this.pan = pan;
	}
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	public long getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(long totalCompra) {
		this.totalCompra = totalCompra;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String date) {
		this.fecha = date;
	}
	
	
}
