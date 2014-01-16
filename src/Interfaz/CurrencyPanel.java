package Interfaz;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;

public class CurrencyPanel extends JPanel{
    JComboBox combo = null;
    public CurrencyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createCombo());
    }

    public JComboBox getCombo() {
        return combo;
    }

    private JComboBox createCombo() {
        CurrencySet set =CurrencySet.load();
        String[] currencies = new String[set.size()];
        int i=0;
        Currency[] currency = set.toArray(new Currency[set.size()]);
        for (Currency currency1 : currency) {
            currencies[i] = currency1.getCode();
            i++;
        }
        combo = new JComboBox(currencies);
        return combo;
    }
    
}
