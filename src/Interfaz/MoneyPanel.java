package Interfaz;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyPanel extends JPanel{
    private JTextField field=null;
    JComboBox combo = null;
    public JTextField getField() {
        return field;
    }
    public MoneyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createTextField());
        CurrencyPanel currencyPanel = new CurrencyPanel();
        combo = currencyPanel.getCombo();
        this.add(currencyPanel);
    }

    public JComboBox getCombo() {
        return combo;
    }

    private JTextField createTextField() {
        field = new JTextField(10);
        return field;
    }
}
