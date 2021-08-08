package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Album;
import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.exceptions.AlbumNaoEncontradoException;
import com.erik5594.blog.domain.exceptions.SemPermissaoExcluirAlbumException;
import com.erik5594.blog.domain.repository.AlbumRepository;
import com.erik5594.blog.domain.service.AlbumService;
import com.erik5594.blog.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 21:00
 */

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Album cadastrar(String emailCriador, Album album) {
        Usuario usuario = usuarioService.buscarPorEmail(emailCriador);
        album.setCriador(usuario);
        return repository.save(album);
    }

    @Override
    public Album buscarPeloId(Long id) {
        Album album = repository.findById(id).orElse(null);
        if(album == null)
            throw new AlbumNaoEncontradoException(id);
        return album;
    }

    @Override
    public void excluir(Long id, String emailUsuario) {
        Album album = buscarPeloId(id);
        if(!isUsuarioCriador(album, emailUsuario))
            throw new SemPermissaoExcluirAlbumException();
        repository.delete(album);
    }

    private boolean isUsuarioCriador(Album album, String emailUsuario){
        return album.getCriador().getEmail().equalsIgnoreCase(emailUsuario);
    }

    public void setRepository(AlbumRepository repository) {
        this.repository = repository;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
