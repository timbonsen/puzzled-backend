package bonsen.nl.puzzled.service.exchange;

import bonsen.nl.puzzled.model.exchange.Exchange;
import bonsen.nl.puzzled.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Exchange getExchange(String id) {
        return null;
    }

    @Override
    public String createExchange(Exchange exchange) {
        exchangeRepository.save(exchange);
        return exchange.getId();
    }

    @Override
    public void deleteExchange(String id) {
        exchangeRepository.deleteById(id);
    }
}
