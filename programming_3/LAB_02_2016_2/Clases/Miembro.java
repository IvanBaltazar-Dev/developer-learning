package LAB02_2016_2.Clases;

import LAB02_2016_2.Clases.Consultable;

import java.util.Date;

abstract class Miembro implements Consultable{
	private static int cont = 1;
	private int id;
	private String nombre;
	private Date fechaNacimiento;
	private String direccion;
	private String email;
	private char sexo;
	
	public Miembro(String nombre,Date fechaNacimiento,
	               	String direccion,String email,char sexo){ 
 		this.id = cont; 
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.email = email;
		this.sexo = sexo;		
		cont++;
	}
	
	public int getId(){
		return this.id;
	}
	public String getNombre(){
		return this.nombre;
	}
}