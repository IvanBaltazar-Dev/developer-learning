package LAB01_2025_1.Clases;

import LAB01_2025_1.Clases.ProgramaAcademico;
import LAB01_2025_1.Clases.DiaSemana;

import java.util.Date;
import java.time.LocalTime;

public class Curso extends ProgramaAcademico{
	private int cantidadDeHorasPorSemana;
	private int cantidadDeCreditosDelCurso;
	private Date fechaDeInicioDeClases;
	private Date fechaDeFinDeClases;
	private DiaSemana diaDeLaSemana;
	private LocalTime horaDeInicioDeClases;
	private LocalTime horaDeFinDeClases;
	
	public Curso(String nombre, String clave, char modalidad, double precio,
			int cantidadDeHorasPorSemana, int cantidadDeCreditosDelCurso, 
			Date fechaDeInicioDeClases, Date fechaDeFinDeClases, 
			DiaSemana diaDeLaSemana, LocalTime horaDeInicioDeClases, 
			LocalTime horaDeFinDeClases){	
		super(nombre,clave,modalidad,precio);
		this.cantidadDeHorasPorSemana = cantidadDeHorasPorSemana;
		this.cantidadDeCreditosDelCurso = cantidadDeCreditosDelCurso;
		this.fechaDeInicioDeClases = fechaDeInicioDeClases;
		this.fechaDeFinDeClases = fechaDeFinDeClases;
		this.diaDeLaSemana = diaDeLaSemana;
		this.horaDeInicioDeClases = horaDeInicioDeClases;
		this.horaDeFinDeClases = horaDeFinDeClases;
	}
	
	public int getCantidadDeCreditosDelCurso(){
		return this.cantidadDeCreditosDelCurso;
	}
	
	@Override
	public String consultar(){
		return "CURSO: " + getClave() + " - " + getNombre() + " - S/. " + getPrecio() + " - CRED: " 
		+ getCantidadDeCreditosDelCurso();
	}	
}