
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;

public class CurrencySetLoader {
    private static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER="system";
    private static final String PASSWORD="orcl";
    public static void load() throws SQLException{
        CurrencySet set = CurrencySet.load();
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM DIVISAS");
        while(resultSet.next()){
            set.add(new Currency(resultSet.getString("DIVISA"),resultSet.getString("NOMBRE"),resultSet.getString("Simbolo")));
        }
        connection.close();
        //set.add(new Currency("USD","Dolar"));
    }
}
