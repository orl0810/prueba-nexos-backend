package com.credibanco.assessment.card.dto;

public class ResponseEnrolCard {
	String cod_respuesta;
	String mensaje;
	String pam_enmascarado;
	
	
	public ResponseEnrolCard(String cod_respuesta, String mensaje, String pam_enmascarado) {
		this.cod_respuesta = cod_respuesta;
		this.mensaje = mensaje;
		this.pam_enmascarado = pam_enmascarado;
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
	public String getPam_enmascarado() {
		return pam_enmascarado;
	}
	public void setPam_enmascarado(String pam_enmascarado) {
		this.pam_enmascarado = pam_enmascarado;
	}
	
	
}
