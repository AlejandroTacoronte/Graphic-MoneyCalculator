package persistence;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;
import moneycalculator.Model.Number;

public class ExchangeRateLoader {
    private static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER="system";
    private static final String PASSWORD="orcl";
    
    public static ExchangeRate load(Currency from,Currency to,Date date) throws SQLException {
        double toChange = 0;
        double fromChange = 0; 
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A where to_date(to_char(ALTA,'dd/mm/yy'),'dd/mm/yy') = to_date('" 
                + cal.get(Calendar.DAY_OF_MONTH) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR) + "','dd/mm/yy') " 
                + "and DIVISA='" + to.getCode() + "'");
        
        while(resultSet.next()){
            toChange = resultSet.getDouble("CAMBIO");
        }
        
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A where to_date(to_char(ALTA,'dd/mm/yy'),'dd/mm/yy') = to_date('" 
                + cal.get(Calendar.DAY_OF_MONTH) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR) + "','dd/mm/yy') " 
                + "and DIVISA='" + from.getCode() + "'");
        
        while(resultSet.next()){
           fromChange = resultSet.getDouble("CAMBIO");
        }
        connection.close();
        return new ExchangeRate(from,to,date,new Number(fromChange/toChange));
    }
}
