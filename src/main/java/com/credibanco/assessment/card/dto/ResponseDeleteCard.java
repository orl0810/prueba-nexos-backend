package com.credibanco.assessment.card.dto;

public class ResponseDeleteCard {
	String cod_respuesta;
	String mensaje;
	
	public ResponseDeleteCard(String cod_respuesta, String mensaje) {
		this.cod_respuesta = cod_respuesta;
		this.mensaje = mensaje;
	}
	public String getCod_respuesta() {
		return cod_respuesta;
	}
	public void setCod_respuesta(String cod_respuesta) {
		this.cod_respuesta = cod_respuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
