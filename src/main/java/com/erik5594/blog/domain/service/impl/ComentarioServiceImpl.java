package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Comentario;
import com.erik5594.blog.domain.entity.Post;
import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.exceptions.ComentarioNaoEncontradoException;
import com.erik5594.blog.domain.exceptions.SemPermissaoExcluirComentarioException;
import com.erik5594.blog.domain.repository.ComentarioRepository;
import com.erik5594.blog.domain.service.ComentarioService;
import com.erik5594.blog.domain.service.PostService;
import com.erik5594.blog.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 10:39
 */

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private PostService postService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ComentarioRepository repository;

    @Override
    public Comentario buscarPorId(Long id) {
        Comentario comentario = repository.findById(id).orElse(null);
        if(comentario == null)
            throw new ComentarioNaoEncontradoException(id);
        return comentario;
    }

    @Override
    public Comentario cadastrar(Comentario comentario, String emailAutor) {
        Post post = postService.buscarPorId(comentario.getPost().getId());
        comentario.setPost(post);

        Usuario usuario = usuarioService.buscarPorEmail(emailAutor);
        comentario.setAutor(usuario);

        comentario.setData(new Date());

        return repository.save(comentario);
    }

    @Override
    public List<Comentario> buscarTodosComentariosDeUmPost(Long idPost) {
        return repository.findAllByPost_IdEquals(idPost);
    }

    @Override
    public void excluir(Long id, String emailUsuario) {
        Comentario comentario = buscarPorId(id);
        if (!isUsuarioCriador(comentario, emailUsuario))
            throw new SemPermissaoExcluirComentarioException();
        repository.delete(comentario);
    }

    private boolean isUsuarioCriador(Comentario comentario, String emailUsuario){
        return comentario.getAutor().getEmail().equalsIgnoreCase(emailUsuario);
    }

    @Override @Transactional
    public void excluirComentariosDoPost(Long idPost) {
        repository.deleteAllByPost_IdEquals(idPost);
    }
}
