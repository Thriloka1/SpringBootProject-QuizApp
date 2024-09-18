package org.quiz.quiz_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QuizMarks {
	@Id
	private int id;
	private int marks;
}
