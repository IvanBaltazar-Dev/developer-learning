package LAB02_2016_2.Clases;

import java.util.Date;

public class Alumno extends Miembro{
	private int codigo;
	private double craest;
	
	public Alumno(String nombre,Date fechaNacimiento,
	               	String direccion,String email,char sexo, int codigo, double craest){
		super(nombre,fechaNacimiento,direccion,email,sexo);
		this.codigo = codigo;
		this.craest = craest;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	public double getCraest(){
		return this.craest;
	}
	
	
	@Override
	public String consultar(){
		String result = "";
		result = "Alumno: " + getCodigo() + " - " + getNombre() + " - " + String.format("%.1f",getCraest()) + "\n";
		return result;
	}
}