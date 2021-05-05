package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.exchange.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, String> {
}
