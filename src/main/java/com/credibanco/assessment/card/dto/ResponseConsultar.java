package com.credibanco.assessment.card.dto;

public class ResponseConsultar {
	String pan;
	String titular;
	String cedula;
	String telefono;
	String estado;
	
	public ResponseConsultar(String pan, String titular, String cedula, String telefono, String estado) {
		this.pan = pan;
		this.titular = titular;
		this.cedula = cedula;
		this.telefono = telefono;
		this.estado = estado;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
