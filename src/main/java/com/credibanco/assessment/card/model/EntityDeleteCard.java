package com.credibanco.assessment.card.model;

import org.springframework.http.HttpStatus;

public class EntityDeleteCard {
	long pan;
	int numero_validacion;
	
	public long getPan() {
		return pan;
	}
	public void setPan(long pan) {
		this.pan = pan;
	}
	public int getNumero_validacion() {
		return numero_validacion;
	}
	public void setNumero_validacion(int numero_validacion) {
		this.numero_validacion = numero_validacion;
	}
	
}
