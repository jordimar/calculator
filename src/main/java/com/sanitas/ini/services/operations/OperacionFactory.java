package com.sanitas.ini.services.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class OperacionFactory {
	
    @Autowired
    private static ApplicationContext context;
    
	public static Operacion crear(String operador) {
				
		 return context.getBean(operador, Operacion.class);
			 
	}
}
