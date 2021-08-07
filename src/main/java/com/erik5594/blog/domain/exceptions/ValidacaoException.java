package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 08:09
 */
public class ValidacaoException extends RuntimeException {
    private int status = 400;

    public ValidacaoException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
