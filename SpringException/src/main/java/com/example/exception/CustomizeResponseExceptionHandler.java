package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
@ExceptionHandler(Exception.class)	
public final ResponseEntity<ErrorDetails> handleAllException(Exception ex,WebRequest request){
	
	ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
	
	return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);	
}

@ExceptionHandler(StudentNotFoundException.class)
public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex,WebRequest request)
{
ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
	
	return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);	
	
	
}

}
