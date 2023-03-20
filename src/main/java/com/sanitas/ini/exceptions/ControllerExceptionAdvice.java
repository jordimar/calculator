package com.sanitas.ini.exceptions;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.corp.calculator.TracerImpl;

@RestControllerAdvice
public class ControllerExceptionAdvice {
	
	private TracerImpl tracer;
	
	ControllerExceptionAdvice(TracerImpl tracer){
		
		this.tracer = tracer;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		ErrorResponse errorResponse = new ErrorResponse("Error en la validación");
		List<String> errors = new ArrayList<>();
        BindingResult bindingResult = ex.getBindingResult();
 
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.add(String.format(" %s - %s;", error.getField(), error.getDefaultMessage()))  ;
        }
             
		errorResponse.setErrors(errors);
        
		tracer.trace(errorResponse.getErrors());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException ex){

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

		tracer.trace(errorResponse.getMessage());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NoSuchBeanDefinitionException.class)
	public ResponseEntity<ErrorResponse> noSuchBeanDefinitionException(NoSuchBeanDefinitionException ex){

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

		tracer.trace(errorResponse.getMessage());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
