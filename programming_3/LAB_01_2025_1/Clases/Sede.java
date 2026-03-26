package LAB01_2025_1.Clases;
import LAB01_2025_1.Clases.ProgramaAcademico;


import java.util.ArrayList;

public class Sede{
	private int id;
	private String nombre;
	private String direccion;
	private ArrayList<ProgramaAcademico> programasAcademicos; 
	
	public Sede(){
		this.programasAcademicos = new ArrayList<>();
	}
	
	public Sede(int id, String nombre, String direccion){
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.programasAcademicos = new ArrayList<>();
	}
	
	public void agregarProgramaAcademico(ProgramaAcademico pa){
		this.programasAcademicos.add(pa);
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String consultarProgramas(){
		String text = "";
		for(ProgramaAcademico pa :  programasAcademicos){
			text += pa.consultar()+ '\n';
		}
		return text;
	}
}