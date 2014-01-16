package Interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.Model.Currency;
import moneycalculator.Model.Money;
import moneycalculator.Model.Number;

public class MoneyDialog {

    public static Money execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double amount = readAmount(reader);
        Currency currency = CurrencyDialog.execute();
        return new Money(new Number(amount), currency);
    }

    private static double readAmount(BufferedReader reader) throws IOException {
        System.out.println("Introduzca la cantidad de dinero deseada: ");
        String amount = reader.readLine();
        return Double.parseDouble(amount);
    }
    
}
