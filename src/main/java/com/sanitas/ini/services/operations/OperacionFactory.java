package com.sanitas.ini.services.operations;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

public class OperacionFactory {

	public static Operacion crear(String operador) {

		ApplicationContext context = ApplicationContextProvider.getContext();

		Operacion operacion = context.getBean(operador, Operacion.class);

		return operacion;
	}
}
