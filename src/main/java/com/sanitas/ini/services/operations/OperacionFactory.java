package com.sanitas.ini.services.operations;

import org.springframework.context.ApplicationContext;

public class OperacionFactory {
    
	public static Operacion crear(String operador) {
			
		ApplicationContext context = ApplicationContextProvider.getContext();
	 
		 return context.getBean(operador, Operacion.class);
			 
	}
}
