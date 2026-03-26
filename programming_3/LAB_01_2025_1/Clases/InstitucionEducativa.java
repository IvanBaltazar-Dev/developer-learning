package LAB01_2025_1.Clases;

import LAB01_2025_1.Clases.Sede;
import java.util.ArrayList;

public class InstitucionEducativa{
	private int id;
	private String ruc;
	private String nombre;
	private ArrayList<Sede> sedes; 
	
	public InstitucionEducativa(){
		this.sedes = new ArrayList<>();
	}
	
	public InstitucionEducativa(int id, String ruc, String nombre){
		this.id = id;
		this.ruc = ruc;
		this.nombre = nombre;
		this.sedes = new ArrayList<>();
	}
	
	public void agregarSede(Sede s){
		this.sedes.add(s);
	}
	
	public String consultarProgramasDeSede(int index){
		String text = "";
		
		Sede sede = sedes.get(index);
		
		text += "Programas disponibles para Intelectuales " + sede.getNombre() + "\n";
		text += sede.consultarProgramas();
		
		return text;
	}
}