
package ua.edu.kibit.credit.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.entity.Card;
import ua.edu.kibit.credit.mapper.CardMapper;
import ua.edu.kibit.credit.repository.CardRepository;

@Service
public class DefaultCardService implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public DefaultCardService(
            CardRepository cardRepository,
            CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    @Transactional
    public void createCard(CardData data) {
        cardRepository.save(cardMapper.toEntity(data));
    }

    @Override
    @Transactional(readOnly = true)
    public CardData retrieveCard(Long cardId) {
        Card card = findCard(cardId);
        return cardMapper.toData(card);
    }

    @Override
    @Transactional
    public void updateCard(Long cardId, CardData data) {
        Card card = findCard(cardId);
        card.setEmail(data.getEmail());
        card.setAmount(data.getAmount());
        cardRepository.save(card);
    }

    @Override
    @Transactional
    public void deleteCard(Long cardId) {
        Card card = findCard(cardId);
        cardRepository.delete(card);
    }

    private Card findCard(Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Card not found: " + cardId
                ));
    }
}
