package LAB02_2016_2.Clases;

import java.util.Date;

public class Profesor extends Miembro{
	private int codigo;
	private String estado;
	
	public Profesor(String nombre,Date fechaNacimiento,
	               	String direccion,String email,char sexo, int codigo, String estado){
		super(nombre,fechaNacimiento,direccion,email,sexo);
		this.codigo = codigo;
		this.estado = estado;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	public String getEstado(){
		return this.estado;
	}
	
	
	@Override
	public String consultar(){
		String result = "";
		result = "Profesor: " + getCodigo() + " - " + getNombre() + " - " + getEstado() + "\n";
		return result;
	}
}