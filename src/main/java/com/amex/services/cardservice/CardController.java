package com.amex.services.cardservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {
	
	 @Autowired
	    private CardService cardService;

	    @PostMapping("/create")
	    public CardDetailsModel createCard(@RequestBody CardDetailsModel card) {
	        return cardService.createCard(card);
	    }

	    @GetMapping("/fetch")
	    public List<CardDetailsModel> getAllCards() {
	        return cardService.getAllCards();
	    }

	    @GetMapping("/{id}")
	    public CardDetailsModel getCardById(@PathVariable Long id) {
	        Optional<CardDetailsModel> cardOptional = cardService.getCardById(id);
	        if (cardOptional.isPresent()) {
	            return cardOptional.get();
	        } else {
	            throw new ResourceNotFoundException("Card not found with id: " + id);
	        }
	    }

	    @PutMapping("/{id}")
	    public CardDetailsModel updateCard(@PathVariable Long id, @RequestBody CardDetailsModel card) {
	        return cardService.updateCard(id, card);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCard(@PathVariable Long id) {
	        cardService.deleteCard(id);
	    }
}
