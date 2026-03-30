package LAB02_2016_2.Clases;

import LAB02_2016_2.Clases.Miembro;

import java.util.ArrayList;

public class Equipo{
	
	private String nombre;
	private String interes;
	private ArrayList<Miembro> miembros;
	
	public Equipo(String nombre,
	              String interes){
		this.nombre = nombre;
		this.interes = interes;
		this.miembros = new ArrayList<>();
	}
	
	public ArrayList<Miembro> getMiembros(){
		return this.miembros;
	}
	
	public void agregarMiembro(Miembro m){
		miembros.add(m);
	}
	
	public String busquedaMiembro(int codigo){
		String result = "";
		for( Miembro m : miembros ){
			if(m.getId() == codigo){
				result = "Miembro encontrado\n"+
				m.consultar();
				return result;
			}
		}
		return "Miembro no encontrado";
	}
	
	public String consultarEquipo(){
		String result = "";
		if(miembros.isEmpty()){
			return "Lista vacia";
		}
		for( Miembro m : miembros ){
			result += m.consultar();
		}
		return result;
	}
}