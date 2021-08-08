package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Album;
import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.exceptions.AlbumNaoEncontradoException;
import com.erik5594.blog.domain.exceptions.SemPermissaoExcluirAlbumException;
import com.erik5594.blog.domain.repository.AlbumRepository;
import com.erik5594.blog.domain.service.UsuarioService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 15:50
 */
public class AlbumServiceImplTeste {

    private AlbumServiceImpl service;
    private UsuarioService usuarioService;
    private AlbumRepository repository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before(){
        service = new AlbumServiceImpl();

        usuarioService = Mockito.mock(UsuarioService.class);
        service.setUsuarioService(usuarioService);

        repository = Mockito.mock(AlbumRepository.class);
        service.setRepository(repository);
    }

    @Test
    public void testeCadastrar() {
        //cenario
        String emailCriador = "teste@teste.com";
        Album album = new Album();
        Mockito.when(usuarioService.buscarPorEmail(emailCriador)).thenReturn(getUsuario());
        Mockito.when(repository.save(album)).thenReturn(album);
        //acao
        service.cadastrar(emailCriador, album);
    }

    @Test
    public void testeAlbumExistente(){
        //cenario
        Long idAlbum = 1l;
        Mockito.when(repository.findById(idAlbum)).thenReturn(Optional.of(new Album()));

        //acao
        service.buscarPeloId(idAlbum);
    }

    @Test
    public void testeAlbumInexistente(){
        //cenario
        Long idAlbum = 1l;
        Mockito.when(repository.findById(idAlbum)).thenReturn(Optional.empty());

        expectedException.expect(AlbumNaoEncontradoException.class);
        expectedException.expectMessage(Matchers.equalTo("Não foi encontrado um álbum com o id '1'."));

        //acao
        service.buscarPeloId(idAlbum);
    }

    @Test
    public void testeExcluir(){
        //cenario
        Long idAlbum = 1l;
        String emailUsuario = "teste@teste.com";
        Mockito.when(repository.findById(idAlbum)).thenReturn(Optional.of(getAlbum()));

        //acao
        service.excluir(idAlbum, emailUsuario);
    }

    @Test
    public void testeExcluirSemPermissao(){
        //cenario
        Long idAlbum = 1l;
        String emailUsuario = "teste1@teste.com";
        Mockito.when(repository.findById(idAlbum)).thenReturn(Optional.of(getAlbum()));

        expectedException.expect(SemPermissaoExcluirAlbumException.class);
        expectedException.expectMessage(Matchers.equalTo("Apenas o usuário que criou o álbum tem permissão para excluí-lo."));
        //acao
        service.excluir(idAlbum, emailUsuario);
    }

    private Usuario getUsuario(){
        return new Usuario("Teste", "teste@teste.com", "1234");
    }

    private Album getAlbum(){
        Album album = new Album("Teste", "Descricao teste");
        album.setCriador(getUsuario());
        return album;
    }
}
