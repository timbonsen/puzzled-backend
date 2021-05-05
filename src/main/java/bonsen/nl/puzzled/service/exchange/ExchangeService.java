package bonsen.nl.puzzled.service.exchange;

import bonsen.nl.puzzled.model.exchange.Exchange;

public interface ExchangeService {
    public abstract String createExchange(Exchange exchange);
    public abstract void deleteExchange(String id);
}
