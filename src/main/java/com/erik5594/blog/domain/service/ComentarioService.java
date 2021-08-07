package com.erik5594.blog.domain.service;

import com.erik5594.blog.domain.entity.Comentario;

import java.util.List;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:02
 */
public interface ComentarioService {
    Comentario buscarPorId(Long id);
    Comentario cadastrar(Comentario comentario, String emailAutor);
    List<Comentario> buscarTodosComentariosDeUmPost(Long idPost);
    void excluir(Long id, String emailUsuario);
    void excluirComentariosDoPost(Long idPost);
}
