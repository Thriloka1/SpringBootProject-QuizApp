package org.quiz.quiz_app.exceptionclasses;

@SuppressWarnings("serial")
public class CannotAttempThisQuiz extends RuntimeException {
	@Override
	public String getMessage() {
		return "cant attempt this quiz. Quiz only not exists";
	}
}
