package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.UsuarioDto;
import com.erik5594.blog.domain.entity.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 11:04
 */
public class UsuarioAssemblerImplTeste {
    private Assembler assembler;

    @Before
    public void before(){
        assembler = new UsuarioAssemblerImpl();
    }

    @Test
    public void testeUsuarioDtoParaEntity(){
        //cenario
        UsuarioDto usuarioDto = new UsuarioDto("Teste", "teste@teste.com", "1234");

        //acao
        Usuario usuario = (Usuario) assembler.dtoToEntity(usuarioDto);

        //verificacao
        Assert.assertEquals(usuarioDto.nome, usuario.getNome());
        Assert.assertEquals(usuarioDto.email, usuario.getEmail());
        Assert.assertEquals(usuarioDto.senha, usuario.getSenha());
    }

    @Test
    public void testeUsuarioEntityParaDto(){
        //cenario
        Usuario usuario = new Usuario("Teste", "teste@teste.com", "1234");

        //acao
        UsuarioDto usuarioDto = (UsuarioDto) assembler.entityToDto(usuario);

        //verificacao
        Assert.assertEquals(usuario.getNome(), usuarioDto.nome);
        Assert.assertEquals(usuario.getEmail(), usuarioDto.email);
        Assert.assertEquals(usuario.getSenha(), usuarioDto.senha);
    }
}
