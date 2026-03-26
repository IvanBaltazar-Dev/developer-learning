package LAB01_2025_1.Principal;

import LAB01_2025_1.Clases.*;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;



/*
Autor: Ivan Piero Baltazar Pinas
Fecha: 25/03/2026
*/
class Principal{
	public static void main(String[] args) throws Exception{
		//Manejador de fechas
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Creamos la institucion educativa
		InstitucionEducativa ie1 = new InstitucionEducativa(1,"1092828764","Intelectuales SAC");
		//Creamos una sede
		Sede sede1 = new Sede(1,"Intelectuales SAC San Miguel","Av. Universitaria 1801");
		//Asociamos la sede a la institucion educativa
		ie1.agregarSede(sede1);
		//Creamos un curso de la sede
		Curso curso1 = new Curso("LENGUAJE DE PROGRAMACION 2", "INF282", 'P',
		1500.00, 4, 5, sdf.parse("20-03-2025"), sdf.parse("08-07-2025"), DiaSemana.MARTES,
		LocalTime.of(8, 0, 0), LocalTime.of(11, 0, 0));
		//Creamos dos talleres de la sede
		Taller taller1 = new Taller("PYTHON PARA INVESTIGACION CUANTITATIVA",
		"TAL725",'V', 500.00, sdf.parse("28-03-2025"),LocalTime.of(13, 0, 0),
		LocalTime.of(16, 0, 0));
		Taller taller2 = new Taller("INTRODUCCION A LATEX","TAL331",'V', 600.00,
		sdf.parse("30-03-2025"),LocalTime.of(18, 0, 0), LocalTime.of(22, 0, 0));
		//Asociamos el curso y los talleres a la sede
		sede1.agregarProgramaAcademico(curso1);
		sede1.agregarProgramaAcademico(taller1);
		sede1.agregarProgramaAcademico(taller2);
		//Consultamos los programas disponibles en la primera sede de la institucion educativa
		String reporte = ie1.consultarProgramasDeSede(0);
		//Imprimimos el reporte
		System.out.print(reporte);
	}
}