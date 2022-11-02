package com.credibanco.assessment.card.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.EntityCard;

@Repository
public interface ICardRepository extends JpaRepository<EntityCard, Integer> {

	@Query(value = "SELECT * FROM cards WHERE card_number = ?1", nativeQuery = true)
	EntityCard find(long pan);
	
	@Query(value = "SELECT * FROM cards WHERE card_number = ?1", nativeQuery = true)
	EntityCard findByPan(long pan);
	
	@Modifying
	@Query(value = "DELETE FROM cards u WHERE u.card_number = :pan AND u.validation_number = :validation", nativeQuery = true)
	Object delete(@Param("pan") long pan, @Param("validation") int validation_number);
}
