package moneycalculator.Model;

public class Number {
    private double number;

    public Number(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }
    
    public void add(double amount) {
        number+=amount;
    }
    
    public void divide(double amount) {
        number/=amount;
    }
    
    public void substract(double amount) {
        number-=amount;
    }
    
    public void multiplicate(double amount) {
        number*=amount;
    }
    
}
