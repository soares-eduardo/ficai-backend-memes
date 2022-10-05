package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ficai4.backend.enums.TipoPerfil;
import com.ficai4.backend.model.Usuario;
import com.ficai4.backend.model.dto.UsuarioDTO;

@Component
public class UsuarioMapper {

    @Autowired
    VisitaMapper visitaMapper;
    
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setTipoPerfil(TipoPerfil.valueOf(usuarioDTO.getTipoPerfil()));
        usuario.setVisitas(visitaMapper.toEntity(usuarioDTO.getVisitas()));

        return usuario;
    }

    public List<Usuario> toEntity(List<UsuarioDTO> listUsuarioDto) {
        return listUsuarioDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDto = new UsuarioDTO();

        usuarioDto.setId(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setTipoPerfil(usuario.getTipoPerfil().getCode());
        usuarioDto.setVisitas(visitaMapper.toDto(usuario.getVisitas()));

        return usuarioDto;
    }

    public List<UsuarioDTO> toDto(List<Usuario> listUsuario) {
        return listUsuario.stream().map(this::toDto).collect(Collectors.toList());
    }
}
