package assessment.model;

public class QuestionAssessment{
	private Question question;
	private int puntaje;
	
	public QuestionAssessment(Question question, int puntaje){
		this.question = question;
		this.puntaje = puntaje;
	}
	
	public Question getQuestion(){
		return question;
	}
}  