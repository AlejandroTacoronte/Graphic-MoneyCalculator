package moneycalculator.Model;

import java.util.Date;

public class ExchangeRate {
    private final Currency from;
    private final Currency to;
    private final Date date;
    private final Number rate;

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public Number getRate() {
        return rate;
    }

    public ExchangeRate(Currency from, Currency to, Date date, Number rate) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.rate = rate;
    }
    
    public ExchangeRate(Currency from, Currency to, Number rate) {
        this.from = from;
        this.to = to;
        this.date = new Date();
        this.rate = rate;
    }
}
