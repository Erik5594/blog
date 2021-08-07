package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class SemPermissaoExcluirComentarioException extends ValidacaoException{
    public SemPermissaoExcluirComentarioException() {
        super("Apenas o usuário que fez o comentário tem permissão para excluí-lo.", 400);
    }
}
