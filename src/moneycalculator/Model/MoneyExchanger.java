package moneycalculator.Model;

public class MoneyExchanger {
    public static Number Exchange(Money money, ExchangeRate rate) {
        Number number = generateNumber(money);
        number.multiplicate(rate.getRate().getNumber());
        return number;
    }
    
    private static Number generateNumber(Money money) {
        return new Number(money.getAmount().getNumber());
    }
}
