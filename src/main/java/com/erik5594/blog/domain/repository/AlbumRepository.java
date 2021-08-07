package com.erik5594.blog.domain.repository;

import com.erik5594.blog.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 21:02
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
