package org.quiz.quiz_app.controller;

import org.quiz.quiz_app.entity.Question;
import org.quiz.quiz_app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	QuestionService ser;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addQuestions(@RequestBody Question question) {
		return ser.addQuestions(question);
	}

	@GetMapping("/all")
	public ResponseEntity<Object> getAllQuestions() {
		return ser.getAllQuestions();
	}

	@GetMapping("/{category}")
	public ResponseEntity<Object> findQuestionsByCategory(@PathVariable String category) {
		return ser.findQuestionsByCategory(category);
	}
	
}
