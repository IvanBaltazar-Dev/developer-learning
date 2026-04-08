package service;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import model.Question;

public class QuestionManager{
	
	private List<Question> questions = new ArrayList<>();
	private List<Question> selected = new ArrayList<>();
	
	Random rand = new Random();
	// Genera un índice entre 0 (inclusive) y el tamaño de la lista (exclusive)
	
	public void add(Question c){
		questions.add(c);
	}
	public List<Question> selectRandomN(int number){
		for(int i = 0; i < number; i++){
			int index = rand.nextInt(questions.size());
			Question question_selected = questions.get(index);
			selected.add(question_selected);
		}
		return selected;
	}
	
	
}