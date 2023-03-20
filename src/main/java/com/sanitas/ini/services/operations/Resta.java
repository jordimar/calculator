package com.sanitas.ini.services.operations;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service("resta")
public class Resta implements Operacion {

	@Override
	public BigDecimal operar(BigDecimal x, BigDecimal y) {
		 
		return x.subtract(y);
	}
}
