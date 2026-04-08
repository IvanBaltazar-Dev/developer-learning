package model;

import java.util.List;
import java.util.ArrayList;

public class SingleChoiceQuestion extends Question{
	private int key;
	private List<String> values = new ArrayList<>();
	
	public SingleChoiceQuestion(int id, String prompt, List<String> values, int key){
		super(id,prompt);
		this.key = key;
		this.values = values;
	}
	
	@Override
	public String devolverDatos(){
		String result = "";
		result = this.getPrompt() + "\n";
		int number = 1;
		for( String s : values ){
			result += number + ". " + s + "\n";
			number++;
		}
		result += "Ingrese su respuesta: ";
		return result;
	}
}