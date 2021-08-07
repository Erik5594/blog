package com.erik5594.blog.domain.repository;

import com.erik5594.blog.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 12:44
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailEquals(String email);

}
