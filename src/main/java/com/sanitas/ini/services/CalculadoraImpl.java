package com.sanitas.ini.services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.sanitas.ini.models.dto.OperacionDto;
import com.sanitas.ini.services.operations.Operacion;
import com.sanitas.ini.services.operations.OperacionFactory;

@Service
public class CalculadoraImpl implements Calculadora {

	@Override
	public BigDecimal calcular(OperacionDto operacionDto) {
		 
		BigDecimal num1;
		BigDecimal num2;
		String operador;
		BigDecimal resultado;
			
		num1 = operacionDto.getNum1();
		num2 = operacionDto.getNum2();
		operador = operacionDto.getOperador();		
	
		Operacion operacion = OperacionFactory.crear(operador); 
	
		resultado = operacion.operar(num1, num2);

		return resultado;		
	}
}