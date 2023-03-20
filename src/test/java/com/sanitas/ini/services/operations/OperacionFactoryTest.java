package com.sanitas.ini.services.operations;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

@ExtendWith(MockitoExtension.class)
class OperacionFactoryTest {

    @InjectMocks
    private OperacionFactory operacionFactory;

    @Mock
    private ApplicationContext  applicationContext;
    
    @Mock
    ApplicationContextProvider applicationContextProvider;
    
	@Test
	void testCrearSuma() {

        String operador ="suma";
        Operacion operacionResp = null;
        
        when(applicationContext.getBean("suma", Operacion.class)).thenReturn(new Suma());
        
        try (MockedStatic<ApplicationContextProvider> ApplicationContextProviderMock = Mockito.mockStatic(ApplicationContextProvider.class)) {
          
        	ApplicationContextProviderMock.when(ApplicationContextProvider::getContext).thenReturn(applicationContext);

            operacionResp = operacionFactory.crear(operador);
            
            assertNotNull(operacionResp);
            assertInstanceOf(Suma.class, operacionResp);
        }
	}          
    
    	@Test
    	void testCrearResta() {

            String operador ="resta";
            Operacion operacionResp = null;
            
            when(applicationContext.getBean("resta", Operacion.class)).thenReturn(new Resta());
            
            try (MockedStatic<ApplicationContextProvider> ApplicationContextProviderMock = Mockito.mockStatic(ApplicationContextProvider.class)) {
              
            	ApplicationContextProviderMock.when(ApplicationContextProvider::getContext).thenReturn(applicationContext);

                operacionResp = operacionFactory.crear(operador);
                
                assertNotNull(operacionResp);
                assertInstanceOf(Resta.class, operacionResp);             
            }                    
    	}
	
    	@Test
    	void testCrearException() {

            String operador ="division";
 
            
            when(applicationContext.getBean("division", Operacion.class)).thenThrow(new NoSuchBeanDefinitionException("No bean named 'division' available"));
            
            try (MockedStatic<ApplicationContextProvider> ApplicationContextProviderMock = Mockito.mockStatic(ApplicationContextProvider.class)) {
              
            	ApplicationContextProviderMock.when(ApplicationContextProvider::getContext).thenReturn(applicationContext);

                Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> operacionFactory.crear(operador));                              
            }                    
    	}
}
