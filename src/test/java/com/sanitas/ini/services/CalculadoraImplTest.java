package com.sanitas.ini.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.sanitas.ini.models.dto.OperacionDto;
import com.sanitas.ini.services.operations.OperacionFactory;
import com.sanitas.ini.services.operations.Resta;
import com.sanitas.ini.services.operations.Suma;

@ExtendWith(MockitoExtension.class)
class CalculadoraImplTest {
		
	@InjectMocks
	CalculadoraImpl service;

    @Test
    void testCalcularSuma() {
    	
 		OperacionDto operacionDtoSuma = new OperacionDto("suma", new BigDecimal("5.0"), new BigDecimal("6.0"));
         
        try (MockedStatic<OperacionFactory> factory = Mockito.mockStatic(OperacionFactory.class)) {
            factory.when(() -> OperacionFactory.crear("suma")).thenReturn(new Suma());
                       
            BigDecimal resp = service.calcular(operacionDtoSuma);

            assertNotNull(resp);
            assertEquals(resp, new BigDecimal("11.0"));
        }
    }
    
    @Test
    void testCalcularResta() {
    	
 		OperacionDto operacionDtoResta = new OperacionDto("resta", new BigDecimal("5.0"), new BigDecimal("3.0"));
         
        try (MockedStatic<OperacionFactory> factory = Mockito.mockStatic(OperacionFactory.class)) {
            factory.when(() -> OperacionFactory.crear("resta")).thenReturn(new Resta());
                       
            BigDecimal resp = service.calcular(operacionDtoResta);

            assertNotNull(resp);
            assertEquals(resp, new BigDecimal("2.0"));
        }
    }
}
