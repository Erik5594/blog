package com.erik5594.blog.domain.service;

import com.erik5594.blog.domain.entity.Post;

import java.util.List;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:02
 */
public interface PostService {
    Post cadastrar(String emailCriador, Post post);
    Post buscarPorId(Long id);
    void excluir(String emailUsuario, Long idPostagem);
    List<Post> buscarTodos();
}
