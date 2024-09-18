package org.quiz.quiz_app.controller;

import java.util.List;

import org.quiz.quiz_app.response.Responses;
import org.quiz.quiz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService qser;

	@PostMapping("/create")
	public ResponseEntity<Object> createQuiz(@RequestParam String category, @RequestParam String title) {
		return qser.createQuiz(category, title);
	}

	@GetMapping("/getquiz/{id}")
	public ResponseEntity<Object> getQuizQuestions(@PathVariable int id) {
		return qser.getQuizQuestions(id);
	}

	@PostMapping("/submit/{id}")
	public ResponseEntity<Object> submitQuiz(@PathVariable int id, @RequestBody List<Responses> res) {

		return qser.calculateResult(id, res);
	}
}