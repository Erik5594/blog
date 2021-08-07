package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.exceptions.*;
import com.erik5594.blog.domain.repository.UsuarioRepository;
import com.erik5594.blog.domain.service.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 12:47
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario buscarPorEmail(String email) {
        return repository.findByEmailEquals(email);
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        this.validar(usuario);
        return repository.save(usuario);
    }

    @Override
    public void deletar(Long id) {
        Usuario usuario = repository.findById(id).orElse(null);
        if(usuario == null)
            throw new UsuarioNaoEncontradoException(id);
        repository.delete(usuario);
    }

    @Override
    public void validar(Usuario usuario) {
        validarNome(usuario.getNome());
        validarEmail(usuario.getEmail());
        validarSenha(usuario.getSenha());
    }

    private void validarEmail(String email){
        if(StringUtils.isBlank(email))
            throw new EmailUsuarioObrigatorioException();
        if(!email.contains("@"))
            throw new EmailUsuarioInvalidoException(email);
    }

    private void validarNome(String nome){
        if(StringUtils.isBlank(nome))
            throw new NomeUsuarioObrigatorioException();
    }

    private void validarSenha(String senha){
        if(StringUtils.isBlank(senha))
            throw new SenhaUsuarioObrigatorioException();
    }
}
