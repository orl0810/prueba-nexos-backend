package com.credibanco.assessment.card.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import com.credibanco.assessment.card.dto.ResponseCancelTransaction;
import com.credibanco.assessment.card.dto.ResponseCard;
import com.credibanco.assessment.card.dto.ResponseCreateTransaction;
import com.credibanco.assessment.card.dto.ResponseEnrolCard;

public class ImplementacionWebService {

	public int getNumeroValidacion() {
		return (int) (Math.random() * 100) + 1;
	}

	public Boolean validatePanSize(long card_number) {
		long longitud = String.valueOf(card_number).length();
		if (longitud < 16 || longitud > 19)
			return false;
		else
			return true;
	}

	public String enmascarar(String pan) {
		return pan.substring(0, 6) + Strings.repeat("*", pan.length() - 10) + pan.substring(pan.length() - 4);
	}

	public ResponseCard getBody(String codigoRespuesta, String pan, int numeroValidacion) {
		if (codigoRespuesta.equals("00")) {
			return new ResponseCard(codigoRespuesta, "Éxito", numeroValidacion, enmascarar(pan));
		} else {
			return new ResponseCard(codigoRespuesta, "Fallido", numeroValidacion, enmascarar(pan));
		}
	}

	public ResponseEnrolCard getBodyEnrol(String codigoRespuesta, String pan) {
		switch (codigoRespuesta) {
		case "00":
			return new ResponseEnrolCard(codigoRespuesta, "Éxito", enmascarar(pan));
		case "01":
			return new ResponseEnrolCard(codigoRespuesta, "Tarjeta no existe", enmascarar(pan));
		case "02":
			return new ResponseEnrolCard(codigoRespuesta, "Número de validación invalido", enmascarar(pan));
		}
		return null;
	}

	public ResponseCreateTransaction getBodyCreateTransaction(String codigoRespuesta, String estado, int referencia) {
		switch (codigoRespuesta) {
		case "00":
			return new ResponseCreateTransaction(codigoRespuesta, "Compra exitosa", estado, referencia);
		case "01":
			return new ResponseCreateTransaction(codigoRespuesta, "Tarjeta no existe", estado, referencia);
		case "02":
			return new ResponseCreateTransaction(codigoRespuesta, "Tarjeta no enrolada", estado, referencia);
		case "03":
			return new ResponseCreateTransaction(codigoRespuesta, "Hubo un error", estado, referencia);
		}
		return null;
	}

	public ResponseCancelTransaction getBodyCancelTransaction(String codigoRespuesta, int referencia) {
		switch (codigoRespuesta) {
		case "00":
			return new ResponseCancelTransaction(codigoRespuesta, "Compra anulada", referencia);
		case "01":
			return new ResponseCancelTransaction(codigoRespuesta, "Número de referencia invalido", referencia);
		case "02":
			return new ResponseCancelTransaction(codigoRespuesta, "No se puede anular transacción", referencia);
		case "03":
			return new ResponseCancelTransaction(codigoRespuesta, "Hubo un error", referencia);
		}
		return null;
	}

	public String getActualDate() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
		System.out.println("FECHAAA:   " + DateFor.format(date));

		return DateFor.format(date);
	}

	public Boolean validarVigenciaCancelacion(String fechaTransaccion) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		try {
			Date dateTransaction = DateFor.parse(fechaTransaccion);
			Date dateActual = new Date();
			int vigencia = (int) Math.floor((dateActual.getTime() - dateTransaction.getTime())/ 60000);
			
			if(vigencia <= 5)
				return true;
			else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
