package LAB01_2025_1.Clases;


import java.util.ArrayList;

abstract public class ProgramaAcademico implements IConsultable{
	private static int cont = 1; 
	private int id;
	private String nombre;
	private String clave;
	private char modalidad;
	private double precio;
	
	public ProgramaAcademico(String nombre, String clave, char modalidad, double precio){
		this.id = cont;
		this.nombre = nombre;
		this.clave = clave;
		this.modalidad = modalidad;
		this.precio = precio;
		cont++;
	}
	
	public String getClave(){
		return clave;
	}
	public String getNombre(){
		return nombre;
	}
	public double getPrecio(){
		return precio;
	}
}