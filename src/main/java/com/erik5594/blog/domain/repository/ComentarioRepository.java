package com.erik5594.blog.domain.repository;

import com.erik5594.blog.domain.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author erik_
 * Data Criacao: 03/08/2021 - 21:06
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findAllByPost_IdEquals(Long idPostagem);
    void deleteAllByPost_IdEquals(Long idPost);
}
