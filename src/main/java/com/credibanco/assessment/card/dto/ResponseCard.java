package com.credibanco.assessment.card.dto;

public class ResponseCard {
	String codigoRespuesta;
	String mensaje;
	int numeroValidacion;
	String pan;

	public ResponseCard(ResponseCard save) {
		// TODO Auto-generated constructor stub
	}

	public ResponseCard() {
		// TODO Auto-generated constructor stub
	}

	public ResponseCard(String codigoRespuesta, String mensaje, int numeroValidacion, String pan) {
		this.codigoRespuesta = codigoRespuesta;
		this.mensaje = mensaje;
		this.numeroValidacion = numeroValidacion;
		this.pan = pan;
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

	public int getNumeroValidacion() {
		return numeroValidacion;
	}

	public void setNumeroValidacion(int numeroValidacion) {
		this.numeroValidacion = numeroValidacion;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
}
