package com.credibanco.assessment.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.model.EntityCancelTransaction;
import com.credibanco.assessment.card.model.EntityCard;
import com.credibanco.assessment.card.model.EntityTransaction;
import com.credibanco.assessment.card.service.CardService;
import com.credibanco.assessment.card.service.TransactionService;
import com.credibanco.assessment.card.service.impl.ImplementacionWebService;


@CrossOrigin(origins= "*")
@Validated
@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private CardController cardController;
	
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/create")
	public ResponseEntity createTransaction(@RequestBody EntityTransaction entityTransaction) {
	
		ImplementacionWebService implement = new ImplementacionWebService();
		
		try {
			EntityCard card = cardController.serchExistCard(entityTransaction.getPan());
			if(card != null) {
				String estadoTarjeta = card.getStade();
				if(estadoTarjeta.equals("Enrolada")) {
					entityTransaction.setFecha(implement.getActualDate());
					transactionService.save(entityTransaction);
					return ResponseEntity.status(HttpStatus.CREATED).body(implement.getBodyCreateTransaction("00", estadoTarjeta, entityTransaction.getReferencia()));
				}
				else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCreateTransaction("02", estadoTarjeta, 0));
				}
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCreateTransaction("01", "No existe", 0));
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCreateTransaction("03", "No existe", 0));
		}
	}
	
	@DeleteMapping("/cancel")
	public ResponseEntity enrolCard(@RequestBody EntityCancelTransaction entityCancelTransaction) {
		ImplementacionWebService implement = new ImplementacionWebService();
		try {
			EntityTransaction transaction = serchTransaction(entityCancelTransaction.getNumeroReferencia()); 
			if(transaction != null) {
				Boolean vigencia = implement.validarVigenciaCancelacion(transaction.getFecha());
				System.out.println("VIGENCIA:  " + vigencia);
				if(vigencia) {
					transactionService.delete(entityCancelTransaction.getNumeroReferencia());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCancelTransaction("00",  entityCancelTransaction.getNumeroReferencia()));
				}
				else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCancelTransaction("02",  entityCancelTransaction.getNumeroReferencia()));
				}
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCancelTransaction("01",  entityCancelTransaction.getNumeroReferencia()));
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(implement.getBodyCancelTransaction("01",  entityCancelTransaction.getNumeroReferencia()));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<EntityTransaction>> findAll() {
		return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
	}
	
	EntityTransaction serchTransaction(int numeroReferencia) {
		try {
			EntityTransaction transaction = transactionService.get(numeroReferencia);
			return transaction;
		}
		catch(Exception e) {
			return null;
		}
	}
}
