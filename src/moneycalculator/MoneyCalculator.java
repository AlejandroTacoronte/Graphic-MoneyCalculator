package moneycalculator;

import Control.ExchangeMoneyControl;
import java.io.IOException;
import java.sql.SQLException;
import persistence.CurrencySetLoader;

public class MoneyCalculator {

    public static void main(String[] args) throws IOException, SQLException {
        CurrencySetLoader.load();
        ExchangeMoneyControl.execute();
    }
    
}
