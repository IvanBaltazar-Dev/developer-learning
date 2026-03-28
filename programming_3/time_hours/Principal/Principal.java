package time_hours.Principal;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Principal{
	public static void main(String[] args)throws Exception{
		
		// Formato de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = new Date();
		Date fecha1 = sdf.parse("30-01-2002");
        // Hora
        LocalTime hora = LocalTime.of(11, 0, 0);

        System.out.println("Hola");
        System.out.println("Fecha: " + sdf.format(fecha));
        System.out.println("Fecha1: " + sdf.format(fecha1));
        System.out.println("Hora: " + hora);
		
	}
}