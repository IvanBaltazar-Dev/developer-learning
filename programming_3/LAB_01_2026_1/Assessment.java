import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Assessment{
	private int minutos;
	private Date fechaHoraInicio;
	private List<Teacher> teachers = new ArrayList<>();
	private List<QuestionAssessment> list_qa = new ArrayList<>();
	
	public Assessment(int minutos, Date fechaHoraInicio, List<Teacher> teachers, List<QuestionAssessment> list_qa){
		this.minutos = minutos;
		this.fechaHoraInicio = fechaHoraInicio;
		this.teachers = teachers;
		this.list_qa = list_qa;
	}
	
	@Override
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		int number = 1;
		String result = "";
		result = "Inicio de examen ================\n";
		result += "Duracion: " + this.minutos + " minutos\n";
		result += "Fecha Hora Inicio: " + sdf.format(fechaHoraInicio) + "\n\n";
		for( QuestionAssessment qa : list_qa){
			Question q = qa.getQuestion();
			result += "Pregunta " + number + ") "; 
			result += q.devolverDatos() + "\n";
			number++;
		}
		return result;
	}
}