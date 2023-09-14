package com.ficai4.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.AlunoMapper;
import com.ficai4.backend.model.dto.AlunoDTO;
import com.ficai4.backend.model.dto.CidadeDTO;
import com.ficai4.backend.model.dto.EnderecoDTO;
import com.ficai4.backend.model.dto.TelefoneDTO;
import com.ficai4.backend.service.AlunoService;
import org.springframework.data.domain.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AlunoController.class)
@Disabled
public class AlunoControllerTest {

        @Autowired
        private MockMvc mvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private AlunoService alunoService;

        @MockBean
        private AlunoMapper alunoMapper;

        @Test
        void itShouldReturnOkStatusWhenFindingAllAlunos() throws Exception {

                int page = 0;
                int size = 10;
                PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

                Mockito.when(alunoService.findAll()).thenReturn(new PageImpl<>(List.of(new AlunoDTO()),
                                pageRequest, size));

                RequestBuilder request = MockMvcRequestBuilders.get("/aluno");
                MvcResult result = mvc.perform(request).andReturn();

                assertEquals(200, result.getResponse().getStatus());

        }

        @Test
        void itShouldReturnOkStatusWhenFindingAlunoById() throws Exception {
                UUID id = UUID.randomUUID();

                Mockito.when(alunoService.findAlunoById(id)).thenReturn(new AlunoDTO());
                RequestBuilder request = MockMvcRequestBuilders.get("/aluno").param("id", String.valueOf(id));
                MvcResult result = mvc.perform(request).andReturn();
                assertEquals(200, result.getResponse().getStatus());
        }

        @Test
        void itShouldReturnNotFoundStatusWhenFindingAlunoById() throws Exception {
                UUID id = UUID.randomUUID();

                Mockito.when(alunoService.findAlunoById(id)).thenThrow(NotFoundException.class);
                RequestBuilder request = MockMvcRequestBuilders.get("/aluno/id").param("id", String.valueOf(id));
                MvcResult result = mvc.perform(request).andReturn();
                assertEquals(404, result.getResponse().getStatus());
        }

        @Test
        void itShouldReturnCreatedStatusWhenCreatinAnAluno() throws Exception {
                EnderecoDTO enderecoDto = new EnderecoDTO("91360-220", "Rua Limoeiro", "135", "Cristo Redentor",
                                "AP 1608",
                                new CidadeDTO("5234565", "Porto Alegre", "RS"), "Perto da Elevato");
                TelefoneDTO telefoneDto = new TelefoneDTO("051", "998732729", "Eduardo");

                AlunoDTO alunoDto = new AlunoDTO("60076180050", "Jose  Soares", "Vinicio Muller", "Maria Souto", "",
                                true,
                                true, List.of(telefoneDto), List.of(enderecoDto), LocalDate.now());

                RequestBuilder request = MockMvcRequestBuilders.post("/aluno")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(alunoDto));

                MvcResult result = mvc.perform(request).andReturn();

                assertEquals(201, result.getResponse().getStatus());
        }

        @Test
        void itShouldReturnBadRequestStatusWhenCreatinAnAluno() throws Exception {
                // CEP com menos de 9 caracteres
                EnderecoDTO enderecoDto = new EnderecoDTO("91360220", "Rua Limoeiro", "135", "Cristo Redentor",
                                "AP 1608",
                                new CidadeDTO("5234565", "Porto Alegre", "RS"), "Perto da Elevato");
                TelefoneDTO telefoneDto = new TelefoneDTO("051", "998732729", "Eduardo");

                AlunoDTO alunoDto = new AlunoDTO("60076180050", "Jose  Soares", "Vinicio Muller", "", "Maria Souto",
                                true,
                                true, List.of(telefoneDto), List.of(enderecoDto), LocalDate.now());

                RequestBuilder request = MockMvcRequestBuilders.post("/aluno")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(alunoDto));

                MvcResult result = mvc.perform(request).andReturn();

                assertEquals(400, result.getResponse().getStatus());
        }

        @Test
        void itShouldReturnOkWhenFindingAlunoByAnyWord() throws Exception {

                int page = 0;
                int size = 10;
                PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

                Mockito.when(alunoService.findByAnyWord("teste", 3, 3, Sort.Direction.ASC, "teste"))
                                .thenReturn(new PageImpl<>(
                                                List.of(new AlunoDTO()),
                                                pageRequest, 3));

                MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

                params.add("palavra", "Bill & Jow");
                params.add("direction", String.valueOf(Sort.Direction.ASC));
                params.add("atributo", "teste");

                RequestBuilder request = MockMvcRequestBuilders.get("/aluno/buscarAluno").params(params);
                MvcResult result = mvc.perform(request).andReturn();
                assertEquals(200, result.getResponse().getStatus());
        }
}
