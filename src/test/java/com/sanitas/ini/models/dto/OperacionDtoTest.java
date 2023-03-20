package com.sanitas.ini.models.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OperacionDtoTest {

    @Test
    public void testOperacionDto() {
    	
        OperacionDto operacion = new OperacionDto("suma", new BigDecimal("5"), new BigDecimal("3"));
        
        assertEquals("suma", operacion.getOperador());
        assertEquals(new BigDecimal("5"), operacion.getNum1());
        assertEquals(new BigDecimal("3"), operacion.getNum2());
    }

    @Test
    public void testOperador() {
    	
        OperacionDto operacion = new OperacionDto("resta", new BigDecimal("5"), new BigDecimal("3"));
        operacion.setOperador("suma");
        assertEquals("suma", operacion.getOperador());
    }

    @Test
    public void testNum1() {
        OperacionDto operacion = new OperacionDto("suma", new BigDecimal("5"), new BigDecimal("3"));
        operacion.setNum1(new BigDecimal("10"));
        assertEquals(new BigDecimal("10"), operacion.getNum1());
    }

    @Test
    public void testNum2() {
        OperacionDto operacion = new OperacionDto("resta", new BigDecimal("5"), new BigDecimal("3"));
        operacion.setNum2(new BigDecimal("7"));
        assertEquals(new BigDecimal("7"), operacion.getNum2());
    }
}
