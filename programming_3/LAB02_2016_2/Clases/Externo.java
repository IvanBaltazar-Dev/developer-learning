package LAB02_2016_2.Clases;

import java.util.Date;

public class Externo extends Miembro{
	private char tipo;
	
	public Externo(String nombre,Date fechaNacimiento,
	               	String direccion,String email,char sexo, char tipo){
		super(nombre,fechaNacimiento,direccion,email,sexo);
		this.tipo = tipo;
	}
	
	public char getTipo(){
		return this.tipo;
	}
	
	@Override
	public String consultar(){
		String result = "";
		result = "Externo: " + getNombre() + " - " + getTipo() + "\n";
		return result;
	}
}