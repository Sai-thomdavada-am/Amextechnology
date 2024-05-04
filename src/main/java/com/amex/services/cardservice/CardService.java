package com.amex.services.cardservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CardService {

	@Autowired
    private CardRepositary cardRepository;

    // Create operation
    public CardDetailsModel createCard(CardDetailsModel card) {
        return cardRepository.save(card);
    }

    // Read operation
    public List<CardDetailsModel> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<CardDetailsModel> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    // Update operation
    public CardDetailsModel updateCard(Long id, CardDetailsModel updatedCard) {
        Optional<CardDetailsModel> optionalCard = cardRepository.findById(id);
        if (optionalCard.isPresent()) {
            CardDetailsModel existingCard = optionalCard.get();
            existingCard.setCardNumber(updatedCard.getCardNumber());
            existingCard.setCardholderName(updatedCard.getCardholderName());
            existingCard.setExpirationDate(updatedCard.getExpirationDate());
            existingCard.setCvv(updatedCard.getCvv());
            return cardRepository.save(existingCard);
        } else {
            throw new IllegalArgumentException("Card not found with id: " + id);
        }
    }

    // Delete operation
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
