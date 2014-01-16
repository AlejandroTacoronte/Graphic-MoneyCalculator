package Interfaz;

import moneycalculator.Model.Money;

public class MoneyViewer {

    public static void refresh(Money money) {
        System.out.println("Son: " + money.getAmount().getNumber() + " " + money.getCurrency().getCode());
    }
    
}
