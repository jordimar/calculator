package com.sanitas.ini.exceptions;

import java.util.List;

public class ErrorResponse {
		  
		  
		  private String message;
		  
		  List<String> errors;
		  
		  ErrorResponse(String message) {
			    this.message = message;
			  }

		  
		  
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}



		public List<String> getErrors() {
			return errors;
		}



		public void setErrors(List<String> errors) {
			this.errors = errors;
		}
		  
		  
}
