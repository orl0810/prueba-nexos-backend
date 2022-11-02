package com.credibanco.assessment.card.model;

public class EntityCancelTransaction {
	long pan;
	int numeroReferencia;
	long totalCompra;
	public long getPan() {
		return pan;
	}
	public void setPan(long pan) {
		this.pan = pan;
	}
	public int getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(int numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	public long getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(long totalCompra) {
		this.totalCompra = totalCompra;
	}
	
	
}
