package ua.edu.kibit.credit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.mapper.CardMapper;
import ua.edu.kibit.credit.repository.CardRepository;

@Service
public class DefaultCardService implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public DefaultCardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    @Transactional
    public void createCard(CardData data) {
        cardRepository.save(cardMapper.toEntity(data));
    }
}
