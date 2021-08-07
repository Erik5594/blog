package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class NomeUsuarioObrigatorioException extends ValidacaoException{
    public NomeUsuarioObrigatorioException() {
        super("Nome do usuário é um parâmetro obrigatório.", 400);
    }
}
