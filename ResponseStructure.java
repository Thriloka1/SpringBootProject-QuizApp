package org.quiz.quiz_app.responsestructure;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseStructure<T> {
	private int httpCode;
	private String msg;
	private T body;
}
