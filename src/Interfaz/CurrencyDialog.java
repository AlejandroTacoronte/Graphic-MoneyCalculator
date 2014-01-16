package Interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;

public class CurrencyDialog {

    public static Currency execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Currency currency = readCurrency(reader);
        return currency;
    }

    private static Currency readCurrency(BufferedReader reader) throws IOException {
        Currency currency = null;
        while (currency==null) {
            System.out.println("Introduzca el código de la divisa: ");
            String symbol = reader.readLine();
            currency = checkSymbol(symbol);
            if(currency==null) System.out.println("Divisa inexistente.");
        }
        return currency;
    }

    private static Currency checkSymbol(String symbol) {
        CurrencySet set = CurrencySet.load();
        for (Currency aux : set) {
            if(aux.getCode().equals(symbol)) {
                return aux;
            }
        }
        return null;
    }
    
}
