package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Endereco;
import com.ficai4.backend.model.dto.EnderecoDTO;

@Component
public class EnderecoMapper {

    @Autowired
    CidadeMapper cidadeMapper;

    public Endereco toEntity(EnderecoDTO enderecoDto) {
        Endereco endereco = new Endereco();

        endereco.setId(enderecoDto.getId());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setCep(enderecoDto.getCep());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setCidade(cidadeMapper.toEntity(enderecoDto.getCidade()));
        endereco.setPontoReferencia(enderecoDto.getPontoReferencia());
        endereco.setDataCadastro(enderecoDto.getDataCadastro());

        return endereco;
    }

    public List<Endereco> toEntity(List<EnderecoDTO> listEnderecoDto) {
        return listEnderecoDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public EnderecoDTO toDto(Endereco endereco) {
        EnderecoDTO enderecoDto = new EnderecoDTO();

        enderecoDto.setId(endereco.getId());
        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setNumero(endereco.getNumero());
        enderecoDto.setCidade(cidadeMapper.toDto(endereco.getCidade()));
        enderecoDto.setPontoReferencia(endereco.getPontoReferencia());
        enderecoDto.setDataCadastro(endereco.getDataCadastro());

        return enderecoDto;
    }

    public List<EnderecoDTO> toDto(List<Endereco> listEndereco) {
        return listEndereco.stream().map(this::toDto).collect(Collectors.toList());
    }
}
