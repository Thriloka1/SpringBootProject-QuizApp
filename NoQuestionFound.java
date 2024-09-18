package org.quiz.quiz_app.exceptionclasses;

@SuppressWarnings("serial")
public class NoQuestionFound extends RuntimeException {
	@Override
	public String getMessage() {
		return "nothing found with your search";
	}
}
