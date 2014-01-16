package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;
import moneycalculator.Model.ExchangeRate;
import moneycalculator.Model.Money;
import moneycalculator.Model.MoneyExchanger;
import persistence.ExchangeRateLoader;
import moneycalculator.Model.Number;

public class MainFrame extends JFrame {
    private JTextField field;
    private JComboBox from;
    private JComboBox to;
    JLabel label;
    public MainFrame() {
        this.setTitle("Money Calculator");
        this.setMinimumSize(new Dimension(300,300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createContent());
        this.add(createToolbar(), BorderLayout.SOUTH);
        label = new JLabel();
        label.setText("Introduzque cantidad y divisas");
        this.add(label,BorderLayout.BEFORE_FIRST_LINE);
    }
    
    private JPanel createContent() {
        JPanel panel = new JPanel();
        MoneyPanel moneyPanel = new MoneyPanel();
        field=moneyPanel.getField();
        from = moneyPanel.getCombo();
        panel.add(moneyPanel);
        CurrencyPanel currencyPanel = new CurrencyPanel();
        to = currencyPanel.getCombo();
        panel.add(currencyPanel);
        return panel;
    }

    private Component createToolbar() {
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        toolbar.add(createCalculateButton());
        toolbar.add(createExitButton());
        return toolbar;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculate();
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return button;
    }
    
    
    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        return button;
    }
    
    private void calculate() throws SQLException{
        System.out.println("Calculating...");
        CurrencySet set=CurrencySet.load();
        Currency currency = null;
        for (Currency aux : set) {
            if(aux.getCode().equals(from.getSelectedItem())) {
                currency = aux;
                break;
            }
        }
        Money moneyFrom = new Money(new Number(Integer.parseInt(field.getText())), currency);
        for (Currency aux : set) {
            if(aux.getCode().equals(to.getSelectedItem())) {
                currency = aux;
                break;
            }
        }
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        ExchangeRate rate=ExchangeRateLoader.load(moneyFrom.getCurrency(),currency,today);
        Number number = MoneyExchanger.Exchange(moneyFrom, rate);
        label.setText("De: " + from.getSelectedItem() + " A: " + number.getNumber()+ to.getSelectedItem());
    }
    
    private void exit(){
        dispose();
    }

    
}
