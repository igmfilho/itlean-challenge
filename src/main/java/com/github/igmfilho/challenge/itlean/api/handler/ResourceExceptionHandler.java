package com.github.igmfilho.challenge.itlean.api.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.igmfilho.challenge.itlean.exception.EmailAlreadyRegisteredException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<?> emailAlreadyRegisteredExceptionHandler(HttpServletRequest req, final EmailAlreadyRegisteredException ex){
		String message = getMessage(ex.getMessageIndex());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(){
        String message = getMessage("error.unexpected");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }

	private String getMessage(final String key) {
       return messageSource.getMessage(key, null, null);
    }
}