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

@RestController
@RequestMapping("/api/calculadora/v1")
public class CalculadoraController {

	private Calculadora calculadora;

	CalculadoraController(Calculadora calculadora) {

		this.calculadora = calculadora;
	}

	@PostMapping("/calcular")
	public ResponseEntity<?> calcular(@Valid @RequestBody OperacionDto operacionDto)
			throws MethodArgumentNotValidException {

			ResultDto resultado = new ResultDto();			

			resultado.setResultado(calculadora.calcular(operacionDto));

			return ResponseEntity.ok(resultado);
	}
}
