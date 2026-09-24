package com.amztecnologia.cicd_facil.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.amztecnologia.cicd_facil.service.SaudacaoService;

@WebMvcTest(SaudacaoController.class)
@Import(SaudacaoService.class)
class SaudacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void deveRetornarSaudacaoPadrao() throws Exception {
        mvc.perform(get("/api/saudacao"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensagem")
                        .value("Identificação confirmada. Mundo você está dentro de uma operação CI/CD"));
    }

    @Test
    void deveRetornarSaudacaoPersonalizada() throws Exception {
        mvc.perform(get("/api/saudacao").param("nome", "André Muniz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensagem")
                        .value("Identificação confirmada. André Muniz você está dentro de uma operação CI/CD"));
    }
}