package com.sanitas.ini.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.ini.models.dto.OperacionDto;
import com.sanitas.ini.models.dto.ResultDto;
import com.sanitas.ini.services.CalculadoraImpl;

@WebMvcTest(CalculadoraController.class)
class CalculadoraControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	CalculadoraImpl service;
	
    private ObjectMapper objectMapper;  
	
	@BeforeEach
	void setUp() {
		
		objectMapper = new ObjectMapper();   
	}
	
	@Test
	void testCalcularControllerSuma() throws Exception {
		
		OperacionDto operationDto = new OperacionDto("suma", new BigDecimal(2.0), new BigDecimal(2.0));
		ResultDto resultado = new ResultDto();
		resultado.setResultado(new BigDecimal(4.0));
		
		when(service.calcular(any())).thenReturn(new BigDecimal(4.0));
		
		mvc.perform(MockMvcRequestBuilders.post("/api/calculadora/v1/calcular").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(operationDto)))
		 	
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.resultado").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.resultado", Matchers.is(4)));
		
		verify(service).calcular(any());
	}

	@Test
	void testCalcularControllerResta() throws Exception {
		
		OperacionDto operationDto = new OperacionDto("resta", new BigDecimal(10.0), new BigDecimal(1.0));
		ResultDto resultado = new ResultDto();
		resultado.setResultado(new BigDecimal(4.0));
		
		when(service.calcular(any())).thenReturn(new BigDecimal(9.0));
		
		mvc.perform(MockMvcRequestBuilders.post("/api/calculadora/v1/calcular").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(operationDto)))
		 		
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.resultado").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.resultado", Matchers.is(9)));
		
		verify(service).calcular(any());
	}
	
	@Test
	void testCalcularControllerSinNum2() throws Exception {
		
		OperacionDto operationDto = new OperacionDto("suma", new BigDecimal(3.0), null);
		
        mvc.perform(MockMvcRequestBuilders.post("/api/calculadora/v1/calcular").contentType(MediaType.APPLICATION_JSON)
 				.content(objectMapper.writeValueAsString(operationDto))) 
 		 		
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
