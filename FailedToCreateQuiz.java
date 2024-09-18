package org.quiz.quiz_app.exceptionclasses;

@SuppressWarnings("serial")
public class FailedToCreateQuiz extends RuntimeException {
	@Override
	public String getMessage() {
		return "category no exists to create quiz";
	}
}
