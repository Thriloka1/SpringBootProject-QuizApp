package org.quiz.quiz_app.exceptionclasses;

@SuppressWarnings("serial")
public class DuplicateQuestionsNotAllowed extends RuntimeException {
	@Override
	public String getMessage() {
		return "This question already exists! try with another one.";
	}
}
