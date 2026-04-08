package assessment.model;

import java.util.List;
import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question{
	private List<String> values = new ArrayList<>();
	private List<Integer> keys = new ArrayList<>();
	
	public MultipleChoiceQuestion(int id, String prompt, List<String> values, List<Integer> keys){
		super(id,prompt);
		this.keys = keys;
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
		result += "Seleccione las opciones de su respuesta: ";
		return result;
	}
}