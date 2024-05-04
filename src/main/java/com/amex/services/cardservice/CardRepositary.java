package com.amex.services.cardservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepositary extends JpaRepository<CardDetailsModel, Long>  {

	
}
