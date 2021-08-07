package com.erik5594.blog.domain.repository;

import com.erik5594.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author erik_
 * Data Criacao: 03/08/2021 - 21:06
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
