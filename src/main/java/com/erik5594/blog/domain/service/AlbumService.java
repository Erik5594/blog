package com.erik5594.blog.domain.service;

import com.erik5594.blog.domain.entity.Album;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:02
 */
public interface AlbumService {
    Album cadastrar(String emailCriador, Album album);
    Album buscarPeloId(Long id);
    void excluir(Long id, String emailUsuario);
}
