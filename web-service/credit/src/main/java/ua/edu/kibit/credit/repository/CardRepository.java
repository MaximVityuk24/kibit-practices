package ua.edu.kibit.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.kibit.credit.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
