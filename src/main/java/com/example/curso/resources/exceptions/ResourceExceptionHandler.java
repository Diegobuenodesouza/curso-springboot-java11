package com.example.curso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.curso.services.exceptions.ResourcerNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler  {

	@ExceptionHandler(ResourcerNotFoundException.class)
	public ResponseEntity<StandardError> resourcerNotFound(ResourcerNotFoundException e , HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;		
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
