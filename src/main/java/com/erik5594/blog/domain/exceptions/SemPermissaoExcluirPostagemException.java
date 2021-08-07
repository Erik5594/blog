package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class SemPermissaoExcluirPostagemException extends ValidacaoException{
    public SemPermissaoExcluirPostagemException() {
        super("Apenas o usuário que criou a postagem tem permissão para excluí-la.", 400);
    }
}
