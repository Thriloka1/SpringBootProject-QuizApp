package org.quiz.quiz_app.exceptionclasses;

@SuppressWarnings("serial")
public class NoQuizFoundForId extends RuntimeException {
	@Override
	public String getMessage() {
		return "failed to get the quizfor your searched id";
	}
}