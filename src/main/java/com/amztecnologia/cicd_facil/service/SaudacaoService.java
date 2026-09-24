package com.amztecnologia.cicd_facil.service;

import org.springframework.stereotype.Service;

@Service
public class SaudacaoService {
	
	public String saudar(String nome) {
		if(nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome é obrigatório.");
		}
		
		return "Identificação confirmada. "+nome.trim()+" você está dentro de uma operação CI/CD";		
	}

}
