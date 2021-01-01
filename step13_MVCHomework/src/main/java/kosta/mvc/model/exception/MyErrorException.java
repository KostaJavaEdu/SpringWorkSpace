package kosta.mvc.model.exception;

import org.springframework.stereotype.Component;

@Component
public class MyErrorException extends Exception{
    private static final long serialVersionUID = 1L;
    
	public MyErrorException() {}
	public MyErrorException(String message) {
		super(message);
	}
}
