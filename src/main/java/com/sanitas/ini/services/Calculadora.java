package com.sanitas.ini.services;

import java.math.BigDecimal;

import com.sanitas.ini.models.dto.OperacionDto;

public interface Calculadora {
	
	BigDecimal calcular(OperacionDto operacionDto);
}
