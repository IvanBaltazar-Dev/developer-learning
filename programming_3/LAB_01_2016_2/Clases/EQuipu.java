package LAB02_2016_2.Clases;

import LAB02_2016_2.Clases.Equipo;
import LAB02_2016_2.Clases.Miembro;

import java.util.ArrayList;


public class EQuipu{

	private ArrayList<Equipo> equipos;
	private ArrayList<Miembro> ejecutivos;
	
	public EQuipu(){
		this.equipos = new ArrayList<>();
		this.ejecutivos = new ArrayList<>();
	}
	
	public void agregarEquipo(Equipo e){
		equipos.add(e);
	}
	public void agregarEjecutivo(Miembro m){
		ejecutivos.add(m);
	}
	
	public String busquedaMiembro(int codigo){
		String result = "";
		for( Equipo e : equipos ){
			for( Miembro m : e.getMiembros() ){
				if(m.getId() == codigo){
					result = "Miembro encontrado\n"+
					m.consultar();
					return result;
				}
			}	
		}
		for( Miembro m : ejecutivos ){
			if(m.getId() == codigo){
				result = "Miembro encontrado\n"+
				m.consultar();
				return result;
			}		
		}
		return "Miembro no encontrado";
	}
	
	public String ConsultarMiembrosDeEquipo(int index){
		String result = "";
		Equipo e = equipos.get(index-1);
		result += e.consultarEquipo();
		
		return result;
	}
}
