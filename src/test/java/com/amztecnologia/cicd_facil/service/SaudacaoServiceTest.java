package com.amztecnologia.cicd_facil.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class SaudacaoServiceTest {
	
	private final SaudacaoService service = new SaudacaoService();
	
	@Test
	void deveSaudarPeloNome() {
	    assertThat(service.saudar("André MUNIZ"))
	            .isEqualTo("Identificação confirmada. André MUNIZ você está dentro de uma operação CI/CD");
	}

	@Test
	void deveRemoverEspacosDoNome() {
	    assertThat(service.saudar("   Andre Muniz    "))
	            .isEqualTo("Identificação confirmada. Andre Muniz você está dentro de uma operação CI/CD");
	}
	
	@Test
	void deveRejeitarNomeVazio() {
		assertThatThrownBy(() -> service.saudar("  "))
		      .isInstanceOf(IllegalArgumentException.class)
		      .hasMessage("O nome é obrigatório.");
	}

}
