package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Post;
import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.exceptions.PostagemNaoEncontradaException;
import com.erik5594.blog.domain.exceptions.SemPermissaoExcluirPostagemException;
import com.erik5594.blog.domain.repository.PostRepository;
import com.erik5594.blog.domain.service.ComentarioService;
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
 * Data Criacao: 08/08/2021 - 18:42
 */
public class PostServiceImplTeste {

    private PostServiceImpl service;
    private UsuarioService usuarioService;
    private PostRepository postRepository;
    private ComentarioService comentarioService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void Before() {
        service = new PostServiceImpl();
        postRepository = Mockito.mock(PostRepository.class);
        service.setRepository(postRepository);

        usuarioService = Mockito.mock(UsuarioService.class);
        service.setUsuarioService(usuarioService);

        comentarioService = Mockito.mock(ComentarioService.class);
        service.setComentarioService(comentarioService);
    }

    @Test
    public void testeCriarPost(){
        //cenario
        String emailCriador = "teste@teste.com";
        Mockito.when(usuarioService.buscarPorEmail(emailCriador)).thenReturn(getUsuario());

        //acao
        service.cadastrar(emailCriador, getPost());
    }

    @Test
    public void testeBuscarPost(){
        //cenario
        Long idPost = 1l;
        Mockito.when(postRepository.findById(idPost)).thenReturn(Optional.of(getPost()));
        //acao

        service.buscarPorId(idPost);
    }

    @Test
    public void testeBuscarPostInexistente(){
        //cenario
        Long idPost = 1l;
        Mockito.when(postRepository.findById(idPost)).thenReturn(Optional.empty());

        expectedException.expect(PostagemNaoEncontradaException.class);
        expectedException.expectMessage(Matchers.equalTo("N??o foi encontrado a postagem com o id '1'."));
        //acao

        service.buscarPorId(idPost);
    }

    @Test
    public void testeExcluirPost(){
        //cenario
        Long idPost = 1l;
        String emailCriador = "teste@teste.com";
        Mockito.when(postRepository.findById(idPost)).thenReturn(Optional.of(getPost()));

        //acao
        service.excluir(emailCriador, idPost);
    }

    @Test
    public void testeExcluirPostSemPermissao(){
        //cenario
        Long idPost = 1l;
        String emailCriador = "teste1@teste.com";
        Mockito.when(postRepository.findById(idPost)).thenReturn(Optional.of(getPost()));

        expectedException.expect(SemPermissaoExcluirPostagemException.class);
        expectedException.expectMessage(Matchers.equalTo("Apenas o usu??rio que criou a postagem tem permiss??o para exclu??-la."));

        //acao
        service.excluir(emailCriador, idPost);
    }

    @Test
    public void testeBuscarTodosPost(){
        service.buscarTodos();
    }

    private Post getPost(){
        Post post = new Post("Teste", "Conteudo teste");
        post.setCriador(getUsuario());
        return post;
    }

    private Usuario getUsuario(){
        return new Usuario("Teste", "teste@teste.com", "1234");
    }

}
