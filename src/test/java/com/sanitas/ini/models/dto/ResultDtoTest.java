package com.sanitas.ini.models.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ResultDtoTest {

	   @Test
	    public void testResultado() {
	        ResultDto resultado = new ResultDto();
	        resultado.setResultado(new BigDecimal("10"));
	        assertEquals(new BigDecimal("10"), resultado.getResultado());
	    }
}
