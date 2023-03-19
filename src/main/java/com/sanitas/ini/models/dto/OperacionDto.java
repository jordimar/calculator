package com.sanitas.ini.models.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OperacionDto {
	
	@NotBlank
	private String operador;
	
	@NotNull
	private BigDecimal num1;
	
	@NotNull
	private BigDecimal num2;
	
	
	public OperacionDto(String operador, BigDecimal num1, BigDecimal num2) {
		super();
		this.operador = operador;
		this.num1 = num1;
		this.num2 = num2;
	}
	
	
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public BigDecimal getNum1() {
		return num1;
	}
	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}
	public BigDecimal getNum2() {
		return num2;
	}
	public void setNum2(BigDecimal num2) {
		this.num2 = num2;
	}
}
