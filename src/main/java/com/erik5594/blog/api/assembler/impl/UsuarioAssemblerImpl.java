package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.UsuarioDto;
import com.erik5594.blog.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:00
 */
@Qualifier("usuario")
@Service
public class UsuarioAssemblerImpl implements Assembler<UsuarioDto, Usuario> {

    @Override
    public Usuario dtoToEntity(UsuarioDto dto) {
        return new Usuario(dto.nome, dto.email, dto.senha);
    }

    @Override
    public UsuarioDto entityToDto(Usuario entity) {
        return new UsuarioDto(entity.getNome(), entity.getEmail(), entity.getSenha());
    }
}
