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
import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.model.dto.AlunoDTO;
import com.ficai4.backend.model.dto.CidadeDTO;
import com.ficai4.backend.model.dto.EnderecoDTO;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.model.dto.TelefoneDTO;
import com.ficai4.backend.model.dto.VisitaDTO;
import com.ficai4.backend.service.AlunoService;
import com.ficai4.backend.service.FichaService;

import org.springframework.data.domain.*;

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

        int page = 0;
        int size = 10;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

        Mockito.when(fichaService.findAll()).thenReturn(new PageImpl<>(
                List.of(new FichaDTO()),
                pageRequest, size));
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
        FichaDTO fichaDTO = new FichaDTO(1, 2, "Aluno não vai na aula.", LocalDate.now(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), null, null, 1);

        RequestBuilder request = MockMvcRequestBuilders.post("/ficha").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(fichaDTO));

        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void itShouldReturnBadRequestStatusWhenCreatingFicha() throws Exception {
        EnderecoDTO enderecoDto = new EnderecoDTO("91360-220", "Rua Limoeiro", "135", "Cristo Redentor", "AP 1608",
                new CidadeDTO("5234565", "Porto Alegre", "RS"), "Perto da Elevato");
        TelefoneDTO telefoneDto = new TelefoneDTO("051", "998732729", "Eduardo");

        AlunoDTO alunoDto = new AlunoDTO("60076180050", "Jose  Soares", "Vinicio Muller", "Maria Souto", true,
                true, List.of(telefoneDto), List.of(enderecoDto), LocalDate.now());

        FichaDTO fichaDTO = new FichaDTO(1, 2, null, LocalDate.now(), alunoDto, UUID.randomUUID(),
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
        RequestBuilder request = MockMvcRequestBuilders.patch("/ficha/visita")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(visitaDto));
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(201, result.getResponse().getStatus());
    }
}
