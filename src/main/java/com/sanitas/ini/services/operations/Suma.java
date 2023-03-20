package com.sanitas.ini.services.operations;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service("suma")
public class Suma implements Operacion{

	@Override
	public BigDecimal operar(BigDecimal x, BigDecimal y) {
		 
		return x.add(y);
	}
}
