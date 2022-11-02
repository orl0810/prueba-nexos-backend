package com.credibanco.assessment.card.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.ResponseCard;
import com.credibanco.assessment.card.dto.ResponseDeleteCard;
import com.credibanco.assessment.card.model.EntityCard;
import com.credibanco.assessment.card.model.EntityDeleteCard;
import com.credibanco.assessment.card.model.EntityEnrolCard;
import com.credibanco.assessment.card.service.impl.ICardRepository;


@Service
public class CardService {
	@Autowired
	private ICardRepository cardRepository;
	
	public List<EntityCard> findAll() {
		return cardRepository.findAll();
	}
	
	public EntityCard save(EntityCard card) {
		return cardRepository.save(card);
	}
	
	public EntityCard get(Integer id) {
		return cardRepository.findById(id).get();
	}
	
	public EntityCard find(long pan) {
		return cardRepository.find(pan);
	}
	
	public EntityCard findByPan(long pan) {
		return cardRepository.findByPan(pan);
	}
	
	public Object delete(EntityDeleteCard entityDeleteCard) {
		return cardRepository.delete(entityDeleteCard.getPan(), entityDeleteCard.getNumero_validacion());
	}
}
