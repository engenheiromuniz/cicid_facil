package com.amztecnologia.cicd_facil.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amztecnologia.cicd_facil.service.SaudacaoService;

@RestController
@RequestMapping("/api/saudacao")
public class SaudacaoController {
	
	private final SaudacaoService service;

	public SaudacaoController(SaudacaoService service) {	
		this.service = service;
	}
	
	@GetMapping
	public Map<String, String> saudar(@RequestParam(defaultValue = "Mundo") String nome){
		return Map.of("mensagem", service.saudar(nome));
	}
	

}
