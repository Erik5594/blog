package com.erik5594.blog.api.assembler;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 14:58
 */
public interface Assembler<T, S> {
    S dtoToEntity(T dto);
    T entityToDto(S entity);
}
