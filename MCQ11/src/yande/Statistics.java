package yande;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Statistics {
	
	private HashMap<Integer, Integer> correctAnswers;
	private HashMap<Integer, ArrayList<Integer>> studentAnswers;
	private HashMap<Integer, ArrayList<Boolean>> correctSet;
	
	// constructor
	public Statistics() {
		this.correctAnswers = yande.Serializer.restore().getCorrect();
		this.studentAnswers = yande.Serializer.restore().getStudent();
		populateCorrectSet();
	}
	
	
	
	private void populateCorrectSet() {
		// create a new map with true/false lists for each question
		HashMap<Integer, ArrayList<Boolean>> correctSet = new HashMap<Integer, ArrayList<Boolean>>();
		ArrayList<Integer> allQuestions = new ArrayList<>(this.correctAnswers.keySet());
		
		for (int q=0; q<allQuestions.size(); q++) { // iterate over every question
			
			// get all results for a question
			ArrayList<Integer> testQuestion = this.studentAnswers.get(q);
			
			for (int a=0; a<testQuestion.size(); a++) { // iterate over every answer
				if (testQuestion.get(a)==this.correctAnswers.get(q)) {
					correctSet.get(q).add(true);
				} else {
					correctSet.get(q).add(false);
				}
			}
		}
		
	}
	
	
	
	public Integer getCorrectCount(Integer q) {
		// get total correct for question q
		// TODO: sort out correctSet reference
		ArrayList<Boolean> testTotal = this.correctSet.get(q);
		
		Integer count = 0;
		for (Boolean value : testTotal) {
			count += (value) ? 1 : 0;
		}
		
		return count;
	}
	
	
	public Integer getTotalCount(Integer q) {
		return this.correctSet.get(q).size();
	}

	
	public Integer getSkippedCount(Integer q) {
		// skipped stored as 0
		ArrayList<Boolean> testSet = this.correctSet.get(q);
		Integer skipped = Collections.frequency(testSet, 0);
		return skipped;
	}
	
	
	
	
	
	
	
	
	
	
	

}
