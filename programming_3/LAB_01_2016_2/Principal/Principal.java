package LAB02_2016_2.Principal;

import LAB02_2016_2.Clases.EQuipu;
import LAB02_2016_2.Clases.Equipo;
import LAB02_2016_2.Clases.Alumno;
import LAB02_2016_2.Clases.Profesor;
import LAB02_2016_2.Clases.Externo;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Principal {
	public static void main(String[] args) throws Exception {
		//Crea una instancia de EQuipu
		EQuipu objEquipu = new EQuipu();
		
		//Se crean los equipos, se asignan los miembros a cada uno 
		Equipo equipo_1 = new Equipo("Los Backyardigans","Desarrollo Web");
		Equipo equipo_2 = new Equipo("LEVEL UP","Circulo de estudio de matematica");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Alumno alumno_1 = new Alumno("Juan Perez",sdf.parse("30-01-2002"),
	               	"Calle Las Gardenias 1928","juanpablo@protonme.com",'M',20202020, 68.3);
		Profesor profesor_1 = new Profesor("Andrea Montenegro",sdf.parse("12-06-1990"),
	               	"Av. Max Hongler 248","AndreaMontenegro@pucp.edu.pe",'F', 46891, "TC");
		Alumno alumno_2 = new Alumno("Viviana Rivasplata",sdf.parse("12-07-1999"),
	               	"Av. Principal 1012","vrivasplata@protonme.com",'F',20254354, 64.5);
		
		equipo_2.agregarMiembro(alumno_1);
		equipo_2.agregarMiembro(profesor_1);
		equipo_2.agregarMiembro(alumno_2);
		
		//equipo y se agregan los equipos a EQuipu
		objEquipu.agregarEquipo(equipo_1);
		objEquipu.agregarEquipo(equipo_2);
		
		//Consulta los miembros del equipo cuyo índice es 2
		String reporte = objEquipu.ConsultarMiembrosDeEquipo(2);
		System.out.println(reporte);

		System.out.println("PROGRAMA FINALIZADO");
	
	}
}
