package moneycalculator.Model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{
    private static CurrencySet set=null;
    private static CurrencySet getInstance() {
        if (set==null)
            return new CurrencySet();
        else
            return set;
    }

    private CurrencySet() {
        super();
    }
    
    public static CurrencySet load() {
         set = CurrencySet.getInstance();
         return set;
    }
}
