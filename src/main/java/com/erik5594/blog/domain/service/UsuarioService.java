package com.erik5594.blog.domain.service;

import com.erik5594.blog.domain.entity.Usuario;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 12:44
 */
public interface UsuarioService {

    Usuario buscarPorEmail(String email);
    Usuario cadastrar(Usuario usuario);
    void deletar(Long id);
    void validar(Usuario usuario);

}
