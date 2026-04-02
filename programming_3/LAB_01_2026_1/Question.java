abstract class Question implements Printable{
	private String prompt;
	private int id;
	
	public Question(int id, String prompt){
		this.id = id;
		this.prompt = prompt;
	}
	
	public String getPrompt(){
		return prompt;
	}
	
	public int getId(){
		return id;
	}
}