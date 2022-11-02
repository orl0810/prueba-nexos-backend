package com.credibanco.assessment.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "cards")
public class EntityCard {
	
	private int validation_number;
	
	@Id
	@Column(nullable = false, unique = true)
	@NotNull(message = "El número de tarjeta no puede estar vacío")
	private long card_number;
	
	@Column(nullable=false)
	@NotNull(message = "El documento no puede estar vacío")
	private Integer document;
	
	@Column(nullable=false, length = 10)
	@NotNull(message = "El teléfono no puede estar vacío")
	private String phone;
	
	private String stade;
	
	@Column(nullable=false)
	@NotEmpty(message = "El titular no puede estar vacío")
	private String owner;
	
	@Column(nullable=false)
	@NotEmpty(message = "El tipo no puede estar vacío")
	private String type;
	
	public EntityCard() {
	}

	public int getValidation_number() {
		return validation_number;
	}

	public void setValidation_number(int validation_number) {
		this.validation_number = validation_number;
	}

	public long getCard_number() {
		return card_number;
	}

	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}

	public Integer getDocument() {
		return document;
	}

	public void setDocument(Integer document) {
		this.document = document;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
