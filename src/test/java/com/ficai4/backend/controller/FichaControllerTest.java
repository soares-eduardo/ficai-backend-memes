package com.ficai4.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.model.dto.HistoricoFichaDTO;
import com.ficai4.backend.model.dto.VisitaDTO;
import com.ficai4.backend.service.AlunoService;
import com.ficai4.backend.service.FichaService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FichaController.class)
public class FichaControllerTest {

    @MockBean
    private AlunoService alunoService;

    @MockBean
    private FichaService fichaService;

    @MockBean
    private FichaMapper fichaMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void itShouldReturnOkStatusWhenFindingAllFichas() throws Exception {
        Mockito.when(fichaService.findAll()).thenReturn(List.of(new FichaDTO()));
        RequestBuilder request = MockMvcRequestBuilders.get("/ficha");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void itShouldReturnOkStatusWhenFindingFichaByAlunoId() throws Exception {
        UUID id = UUID.randomUUID();
        
        Mockito.when(fichaService.findFichaByAlunoId(id)).thenReturn(new FichaDTO());
        RequestBuilder request = MockMvcRequestBuilders.get("/ficha/alunoId").param("alunoId", String.valueOf(id));
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void itShouldReturnCreatedStatusWhenCreatingFicha() throws Exception {
        // HistoricoFichaDTO historicoFicha = new HistoricoFichaDTO(LocalDate.now(), 1,
        // 2);
        FichaDTO fichaDTO = new FichaDTO(1, 2, "Aluno não vai na aula.", LocalDate.now(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), null, null, 1);

        RequestBuilder request = MockMvcRequestBuilders.post("/ficha").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(fichaDTO));

        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void itShouldReturnBadRequestStatusWhenCreatingFicha() throws Exception {
        FichaDTO fichaDTO = new FichaDTO(1, 2, null, LocalDate.now(), UUID.randomUUID(), UUID.randomUUID(),
                UUID.randomUUID(), null, null, 1);

        RequestBuilder request = MockMvcRequestBuilders.post("/ficha").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(fichaDTO));

        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void itShouldReturnCreatedStatusWhenCreatingVisita() throws Exception {
        VisitaDTO visitaDto = new VisitaDTO("Teste", "Teste", true, LocalDate.now());
        
        Mockito.when(fichaService.createVisita(visitaDto)).thenReturn(new VisitaDTO());
        RequestBuilder request = MockMvcRequestBuilders.patch("/ficha/visita").contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(visitaDto));
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(201, result.getResponse().getStatus());
    }
}
