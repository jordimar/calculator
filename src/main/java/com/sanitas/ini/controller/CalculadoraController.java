package com.sanitas.ini.controller;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sanitas.ini.models.dto.OperacionDto;
import com.sanitas.ini.models.dto.ResultDto;
import com.sanitas.ini.services.Calculadora;
import io.corp.calculator.TracerImpl;

@RestController
@RequestMapping("/api/calculadora/v1")
public class CalculadoraController {

	private Calculadora calculadora;
    private TracerImpl tracer;
	

	CalculadoraController(Calculadora calculadora, TracerImpl tracer) {

		this.calculadora = calculadora;
		this.tracer = tracer;
	}

	@PostMapping("/calcular")
	public ResponseEntity<?> calcular(@Valid @RequestBody OperacionDto operacionDto)
			throws MethodArgumentNotValidException {

			ResultDto resultado = new ResultDto();			

			resultado.setResultado(calculadora.calcular(operacionDto));

			tracer.trace(resultado.getResultado());
			
			return ResponseEntity.ok(resultado);
	}
}
