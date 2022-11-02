package com.credibanco.assessment.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.EntityCard;
import com.credibanco.assessment.card.model.EntityDeleteCard;
import com.credibanco.assessment.card.model.EntityTransaction;
import com.credibanco.assessment.card.service.impl.ITransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private ITransactionRepository transactionRepository;
	
	public List<EntityTransaction> findAll() {
		return transactionRepository.findAll();
	}
	
	public EntityTransaction save(EntityTransaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public EntityTransaction get(int numeroReferencia) {
		return transactionRepository.findById(numeroReferencia).get();
	}
	
	public void delete(int numeroReferencia) {
		transactionRepository.deleteById(numeroReferencia);
	}
}
