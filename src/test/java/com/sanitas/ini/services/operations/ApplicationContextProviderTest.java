package com.sanitas.ini.services.operations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

@ExtendWith(MockitoExtension.class)
class ApplicationContextProviderTest {

    @Mock
    private ApplicationContext  applicationContext;
    
    @InjectMocks
    ApplicationContextProvider applicationContextProvider;
    
	@Test
	void test() {

		applicationContextProvider.setApplicationContext(applicationContext);

	        assertNotNull(ApplicationContextProvider.getContext());
	}
}
