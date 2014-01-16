package Interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Calendar;

public class DateDialog {

    public static Date execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca el día: ");
        String day = reader.readLine();
        System.out.println("Introduzca el mes: ");
        String month = reader.readLine();
        System.out.println("Introduzca el año: ");
        String year = reader.readLine();
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return cal.getTime();
    }
    
}
