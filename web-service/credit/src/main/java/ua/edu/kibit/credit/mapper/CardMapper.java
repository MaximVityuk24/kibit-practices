
package ua.edu.kibit.credit.mapper;

import org.springframework.stereotype.Component;
import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.entity.Card;

@Component
public class CardMapper {

    public Card toEntity(CardData data) {
        Card card = new Card();
        card.setEmail(data.getEmail());
        card.setAmount(data.getAmount());
        return card;
    }

    public CardData toData(Card card) {
        CardData data = new CardData();
        data.setEmail(card.getEmail());
        data.setAmount(card.getAmount());
        return data;
    }
}
