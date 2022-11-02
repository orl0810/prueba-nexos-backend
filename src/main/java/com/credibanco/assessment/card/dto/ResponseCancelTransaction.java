package com.credibanco.assessment.card.dto;

public class ResponseCancelTransaction {
	String codigoRespuesta;
	String mensaje;
	int numeroReferencia;
	public ResponseCancelTransaction(String codigoRespuesta, String mensaje, int numeroReferencia) {
		this.codigoRespuesta = codigoRespuesta;
		this.mensaje = mensaje;
		this.numeroReferencia = numeroReferencia;
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
	public int getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(int numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	
	
}
