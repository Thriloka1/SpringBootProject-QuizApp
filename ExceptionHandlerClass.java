package org.quiz.quiz_app.exceptionhandler;

import org.quiz.quiz_app.exceptionclasses.CannotAttempThisQuiz;
import org.quiz.quiz_app.exceptionclasses.DuplicateQuestionsNotAllowed;
import org.quiz.quiz_app.exceptionclasses.FailedToCreateQuiz;
import org.quiz.quiz_app.exceptionclasses.NoQuestionFound;
import org.quiz.quiz_app.exceptionclasses.NoQuizFoundForId;
import org.quiz.quiz_app.exceptionclasses.SeeNothing;
import org.quiz.quiz_app.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {
	@ExceptionHandler(NoQuestionFound.class)
	public ResponseEntity<Object> noQuestionFoundExceptionHandler(NoQuestionFound e) {
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.NOT_FOUND.value());
		res.setMsg("try again");
		res.setBody(e.getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateQuestionsNotAllowed.class)
	public ResponseEntity<Object> duplicateQuestionsNotAllowedExceptionHandler(SeeNothing e) {
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.NOT_FOUND.value());
		res.setMsg("empty!");
		res.setBody(e.getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SeeNothing.class)
	public ResponseEntity<Object> seeNothingExceptionHandler(DuplicateQuestionsNotAllowed e) {
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.NOT_ACCEPTABLE.value());
		res.setMsg("Duplicacy not encouragable");
		res.setBody(e.getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(FailedToCreateQuiz.class)
	public ResponseEntity<Object> failedToCreateQuizExceptionHandler(FailedToCreateQuiz e) {
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.BAD_REQUEST.value());
		res.setMsg("failed to create quiz");
		res.setBody(e.getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoQuizFoundForId.class)
	public ResponseEntity<Object> noQuizFoundForIdExceptionHandler(NoQuizFoundForId e) {
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.NOT_FOUND.value());
		res.setMsg("failed to get the quiz");
		res.setBody(e.getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CannotAttempThisQuiz.class)
	public ResponseEntity<Object> CannotAttempThisQuizExceptionHandler(CannotAttempThisQuiz e) {
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.NOT_FOUND.value());
		res.setMsg("go home");
		res.setBody(e.getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
	}
}