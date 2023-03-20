package com.sanitas.ini;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import io.corp.calculator.TracerImpl;

class CalculatorApplicationTest {

    @Test
    public void testGetTracerApiInstance() {
       
        CalculatorApplication calculator = new CalculatorApplication();
        
        TracerImpl tracer = calculator.getTracerApiInstance();
        
        assertNotNull(tracer);
        assertTrue(tracer instanceof TracerImpl);
    }
}
