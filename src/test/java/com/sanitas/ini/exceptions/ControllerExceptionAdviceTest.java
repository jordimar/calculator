package com.sanitas.ini.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.sanitas.ini.models.dto.OperacionDto;
import io.corp.calculator.TracerImpl;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionAdviceTest {

    @InjectMocks
    private ControllerExceptionAdvice controllerExceptionAdvice;

    @Mock
    private TracerImpl tracer;
    
	  @Test
		public void testIllegalArgumentException() {
		  
	        IllegalArgumentException ex = new IllegalArgumentException("Operación no encontrada");
	        
	        ResponseEntity<ErrorResponse> response = controllerExceptionAdvice.illegalArgumentException(ex);
	        
	        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	        assertEquals("Operación no encontrada", response.getBody().getMessage());
	        
	        verify(tracer).trace("Operación no encontrada");
	    }

	@Test
	void testMethodArgumentNotValidException() {
		
		OperacionDto operacionDto = new  OperacionDto("suma", new BigDecimal("5.0"), new BigDecimal("6.0"));
		BindingResult bindingResult = new BeanPropertyBindingResult(operacionDto, "operacionDto");
		bindingResult.addError(new FieldError("operacionDto", "num1", "no debe ser nulo"));
		bindingResult.addError(new FieldError("operacionDto", "num2", "no debe ser nulo"));
		MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);
		
		ResponseEntity<ErrorResponse> response = controllerExceptionAdvice.methodArgumentNotValidException(exception);
		
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());       
        assertEquals(2, response.getBody().getErrors().size());  		 
	}

    @Test
    public void testNoSuchBeanDefinitionException() {
    	
        NoSuchBeanDefinitionException ex = new NoSuchBeanDefinitionException("division");
        
        ResponseEntity<ErrorResponse> response = controllerExceptionAdvice.noSuchBeanDefinitionException(ex);
        
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("No bean named 'division' available", response.getBody().getMessage());
        
        verify(tracer).trace("No bean named 'division' available");
    }
}
