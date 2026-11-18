
package ua.edu.kibit.credit.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.edu.kibit.credit.constants.HttpMessage;
import ua.edu.kibit.credit.constants.HttpStatus;
import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.dto.ResponseData;
import ua.edu.kibit.credit.service.CardService;

@RestController
@RequestMapping("/api")
public class CreditController {

    private final CardService cardService;

    public CreditController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData> createCard(
            @Valid @RequestBody CardData cardData) {

        cardService.createCard(cardData);

        return ResponseEntity
                .status(org.springframework.http.HttpStatus.CREATED)
                .body(new ResponseData(
                        HttpStatus.CREATED,
                        HttpMessage.CARD_CREATED
                ));
    }

    @GetMapping("/retrieve/{cardId}")
    public ResponseEntity<CardData> retrieveCard(
            @PathVariable Long cardId) {

        return ResponseEntity.ok(
                cardService.retrieveCard(cardId)
        );
    }

    @PutMapping("/update/{cardId}")
    public ResponseEntity<Void> updateCard(
            @PathVariable Long cardId,
            @Valid @RequestBody CardData cardData) {

        cardService.updateCard(cardId, cardData);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseEntity<Void> deleteCard(
            @PathVariable Long cardId) {

        cardService.deleteCard(cardId);
        return ResponseEntity.noContent().build();
    }
}
