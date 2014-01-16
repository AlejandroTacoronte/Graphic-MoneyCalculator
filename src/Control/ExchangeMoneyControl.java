package Control;

import Interfaz.CurrencyDialog;
import Interfaz.DateDialog;
import Interfaz.MoneyDialog;
import Interfaz.MoneyViewer;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import moneycalculator.Model.Currency;
import moneycalculator.Model.Money;
import moneycalculator.Model.MoneyExchanger;
import persistence.ExchangeRateLoader;

public class ExchangeMoneyControl {
    public static void execute() throws IOException, SQLException {
        Money money = MoneyDialog.execute();
        Currency to = CurrencyDialog.execute();
        Date date = DateDialog.execute();
        MoneyViewer.refresh(new Money(MoneyExchanger.Exchange(money, ExchangeRateLoader.load(money.getCurrency(),to,date)),to));
    }
}
