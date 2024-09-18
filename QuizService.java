package org.quiz.quiz_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.quiz.quiz_app.dao.QuestionDao;
import org.quiz.quiz_app.dao.QuizDao;
import org.quiz.quiz_app.entity.Question;
import org.quiz.quiz_app.entity.Quiz;
import org.quiz.quiz_app.exceptionclasses.CannotAttempThisQuiz;
import org.quiz.quiz_app.exceptionclasses.FailedToCreateQuiz;
import org.quiz.quiz_app.exceptionclasses.NoQuizFoundForId;
import org.quiz.quiz_app.questionwrapper.QuestionWrapper;
import org.quiz.quiz_app.response.Responses;
import org.quiz.quiz_app.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

	@Autowired
	QuizDao qdao;
	@Autowired
	QuestionDao dao;

	public ResponseEntity<Object> createQuiz(String category, String title) {

		List<Question> questions = dao.findRandomQuestionsByCategory(category);
		if (questions.isEmpty())
			throw new FailedToCreateQuiz();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		qdao.save(quiz);
		ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.CREATED.value());
		res.setMsg("found");
		res.setBody(quiz);
		return new ResponseEntity<Object>(res, HttpStatus.CREATED);

	}

	public ResponseEntity<Object> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = qdao.findById(id);
        if(quiz.isEmpty())
        	throw new NoQuizFoundForId();
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.FOUND.value());
		res.setMsg("found");
		res.setBody(questionsForUser);
		return new ResponseEntity<Object>(res, HttpStatus.FOUND);

    }

	public ResponseEntity<Object> calculateResult(Integer id, List<Responses> res2) {
        Quiz quiz = qdao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        if(questions.isEmpty())
        	throw new CannotAttempThisQuiz();
        int right = 0;
        int i = 0;
        for(Responses response : res2){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        ResponseStructure<Object> res = new ResponseStructure<>();
		res.setHttpCode(HttpStatus.FOUND.value());
		res.setMsg("found");
		res.setBody(right);
		return new ResponseEntity<Object>(res, HttpStatus.FOUND);

	}
}
