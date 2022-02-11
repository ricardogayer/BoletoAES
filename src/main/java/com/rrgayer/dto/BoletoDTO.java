package com.rrgayer.dto;

import java.math.BigDecimal;

public class BoletoDTO {
	
	private Long id;
	private String linhaDigitavel;
	private BigDecimal valor;

	public String getLinhaDigitavel() {
		return linhaDigitavel;
	}

	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BoletoDTO() {

	}

	public BoletoDTO(Long id, String linhaDigitavel, BigDecimal valor) {
		super();
		this.id = id;
		this.linhaDigitavel = linhaDigitavel;
		this.valor = valor;
	}
	
}
