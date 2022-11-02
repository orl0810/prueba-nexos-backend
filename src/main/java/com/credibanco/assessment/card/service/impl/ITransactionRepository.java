package com.credibanco.assessment.card.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.EntityCard;
import com.credibanco.assessment.card.model.EntityTransaction;

@Repository
public interface ITransactionRepository extends JpaRepository<EntityTransaction, Integer> {
	
}
