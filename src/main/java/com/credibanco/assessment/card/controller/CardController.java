package com.credibanco.assessment.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.ResponseCard;
import com.credibanco.assessment.card.dto.ResponseConsultar;
import com.credibanco.assessment.card.dto.ResponseDeleteCard;
import com.credibanco.assessment.card.dto.ResponseEnrolCard;
import com.credibanco.assessment.card.model.EntityCard;
import com.credibanco.assessment.card.model.EntityDeleteCard;
import com.credibanco.assessment.card.model.EntityEnrolCard;
import com.credibanco.assessment.card.service.CardService;
import com.credibanco.assessment.card.service.impl.ICardRepository;
import com.credibanco.assessment.card.service.impl.ImplementacionWebService;

@CrossOrigin(origins= "*")
@Validated
@RestController
@RequestMapping("/tarjetas")
public class CardController {
	@Autowired
	private CardService cardService;
	
	@PostMapping("/create")
	public ResponseEntity createCard(@RequestBody EntityCard entityCard) {
		ImplementacionWebService implement = new ImplementacionWebService();
		try {
			Boolean validPan = implement.validatePanSize(entityCard.getCard_number());
			if(validPan) {

//				if(serchExistCard(entityCard.getCard_number()) == null) {
//					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBody("01", String.valueOf(entityCard.getCard_number()), 0));
//				}
				
				int numero_validacion = implement.getNumeroValidacion();

				entityCard.setStade("Creada");
				entityCard.setValidation_number(numero_validacion);
				cardService.save(entityCard);
				return new ResponseEntity<>(implement.getBody("00", String.valueOf(entityCard.getCard_number()), numero_validacion), HttpStatus.CREATED);
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBody("01", String.valueOf(entityCard.getCard_number()), 0));
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBody("01", String.valueOf(entityCard.getCard_number()), 0));
		}
		
	}
	
	
	@PutMapping("/enrol")
	public ResponseEntity enrolCard(@RequestBody EntityEnrolCard entityEnrolCard) {
		ImplementacionWebService implement = new ImplementacionWebService();

		try {
			EntityCard card = serchExistCard(entityEnrolCard.getPan());
			if(card.getValidation_number() != entityEnrolCard.getNumero_validacion()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyEnrol("02", String.valueOf(entityEnrolCard.getPan())));
			}
			card.setStade("Enrolada");
			cardService.save(card);
			return ResponseEntity.status(HttpStatus.CREATED).body(implement.getBodyEnrol("00", String.valueOf(entityEnrolCard.getPan())));
			
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyEnrol("02", String.valueOf(entityEnrolCard.getPan())));
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EntityCard>> findAll() {
		return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{pan}")
	public ResponseConsultar findById(@PathVariable long pan) {
		ImplementacionWebService implement = new ImplementacionWebService();
		ResponseEntity<EntityCard> response = new ResponseEntity<>(cardService.findByPan(pan), HttpStatus.OK);
		EntityCard tarjeta = response.getBody();
		return new ResponseConsultar(implement.enmascarar(String.valueOf(tarjeta.getCard_number())), tarjeta.getOwner(), tarjeta.getDocument().toString(),  tarjeta.getPhone(),tarjeta.getStade());
	}
	
	@DeleteMapping("/")
	public ResponseDeleteCard delete(@RequestBody EntityDeleteCard entityDeleteCard) {
		try {
			Object response = cardService.delete(entityDeleteCard);
			return new ResponseDeleteCard("00", "Se ha eliminado la tarjeta");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseDeleteCard("01", "No se ha eliminado la tarjeta");
	}
	
	EntityCard serchExistCard(long cardNumber) {
		try {
			EntityCard card = cardService.find(cardNumber);
			return card;
		}
		catch(Exception e) {
			return null;
		}
	}
	
}
