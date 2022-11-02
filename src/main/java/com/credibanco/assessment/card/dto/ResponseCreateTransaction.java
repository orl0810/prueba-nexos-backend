package com.credibanco.assessment.card.dto;

public class ResponseCreateTransaction {
	
	String codigoRespuesta;
	String mensaje;
	String estado;
	int referencia;
	
	public ResponseCreateTransaction(String codigoRespuesta, String mensaje, String estado, int referencia) {
		this.codigoRespuesta = codigoRespuesta;
		this.mensaje = mensaje;
		this.estado = estado;
		this.referencia = referencia;

	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumeroReferencia() {
		return referencia;
	}
	public void setNumeroReferencia(int numeroReferencia) {
		this.referencia = numeroReferencia;
	}
	
	
}
