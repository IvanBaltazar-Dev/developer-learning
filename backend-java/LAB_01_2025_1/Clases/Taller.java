package LAB01_2025_1.Clases;

import LAB01_2025_1.Clases.ProgramaAcademico;

import java.util.Date;
import java.time.LocalTime;
import java.text.SimpleDateFormat;

public class Taller extends ProgramaAcademico{
	private Date fechaDeRealizacionDeTaller;
	private LocalTime horaDeInicioDeTaller;
	private LocalTime horaDeFinDeTaller;
	
	public Taller(String nombre, String clave, char modalidad, double precio,
			Date fechaDeRealizacionDeTaller, LocalTime horaDeInicioDeTaller, 
			LocalTime horaDeFinDeTaller){	
		super(nombre,clave,modalidad,precio);
		this.fechaDeRealizacionDeTaller = fechaDeRealizacionDeTaller;
		this.horaDeInicioDeTaller = horaDeInicioDeTaller;
		this.horaDeFinDeTaller = horaDeFinDeTaller;
	}
	
	@Override
	public String consultar(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return "TALLER: " + getClave() + " - " + getNombre() + " - S/. " + 
		String.format("%.2f",getPrecio()) + " - Fecha: " 
		+ sdf.format(fechaDeRealizacionDeTaller);
	}	
}