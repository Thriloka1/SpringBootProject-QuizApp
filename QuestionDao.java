package org.quiz.quiz_app.dao;

import java.util.List;
import java.util.Optional;

import org.quiz.quiz_app.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findQuestionsByCategory(String category);

	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND()",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category);

	Optional<Question> findByQuestionTitle(String questionTitle);


}
