package org.quiz.quiz_app.exceptionclasses;

@SuppressWarnings("serial")
public class SeeNothing extends RuntimeException {
	@Override
	public String getMessage() {
		return "No questions";
	}
}
