package com.rrgayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrgayer.dto.BoletoDTO;
import com.rrgayer.model.Boleto;
import com.rrgayer.repository.BoletoRepository;
import com.rrgayer.util.AES256;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

	@Autowired
	private BoletoRepository boletoRepository;

	@GetMapping("/{id}")
	public BoletoDTO getBoletoById(@PathVariable Long id) {
		
		Boleto boleto = boletoRepository.findById(id).get();
		
		BoletoDTO boletoDTO = new BoletoDTO();
		boletoDTO.setId(boleto.getId());
		boletoDTO.setLinhaDigitavel(AES256.decrypt(boleto.getLinhaDigitavel()));
		boletoDTO.setValor(boleto.getValor());
		
		return boletoDTO;
	}

	@PostMapping
	public BoletoDTO saveBoleto(@RequestBody BoletoDTO boletoDTO) {

		Boleto boleto = new Boleto();
	    
		boleto.setLinhaDigitavel(AES256.encrypt(boletoDTO.getLinhaDigitavel()));
		boleto.setValor(boletoDTO.getValor());

		Boleto b = boletoRepository.save(boleto);
		
		BoletoDTO resultado = new BoletoDTO();
		resultado.setId(b.getId());
		resultado.setLinhaDigitavel(AES256.decrypt(b.getLinhaDigitavel()));
		resultado.setValor(b.getValor());	
		
		return resultado;

	}

}
