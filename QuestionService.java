package org.quiz.quiz_app.service;

import java.util.List;
import java.util.Optional;

import org.quiz.quiz_app.dao.QuestionDao;
import org.quiz.quiz_app.entity.Question;
import org.quiz.quiz_app.exceptionclasses.DuplicateQuestionsNotAllowed;
import org.quiz.quiz_app.exceptionclasses.NoQuestionFound;
import org.quiz.quiz_app.exceptionclasses.SeeNothing;
import org.quiz.quiz_app.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	@Autowired
	QuestionDao dao;

	public ResponseEntity<Object> getAllQuestions() {
		List<Question> all = dao.findAll();
		if (all.isEmpty())
			throw new SeeNothing();
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.FOUND.value());
		res.setMsg("see here");
		res.setBody(all);
		return new ResponseEntity<Object>(res, HttpStatus.FOUND);
	}

	public ResponseEntity<Object> findQuestionsByCategory(String category) {
		List<Question> q = dao.findQuestionsByCategory(category);
		if (q.isEmpty())
			throw new NoQuestionFound();
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.FOUND.value());
		res.setMsg("see results!");
		res.setBody(q);
		return new ResponseEntity<Object>(res,HttpStatus.FOUND);
	}

	public ResponseEntity<Object> addQuestions(Question question) {
		Optional<Question> q = dao.findByQuestionTitle(question.getQuestionTitle());
		if (q.isPresent())
			throw new DuplicateQuestionsNotAllowed();
		Question save = dao.save(question);
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.ACCEPTED.value());
		res.setMsg("success!");
		res.setBody(save);
		return new ResponseEntity<Object>(res,HttpStatus.ACCEPTED);
	}

}