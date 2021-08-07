package com.erik5594.blog.api.handler;

import com.erik5594.blog.api.dto.DetalheErro;
import com.erik5594.blog.domain.exceptions.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 08:34
 */

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<DetalheErro> handleValidacaoException
            (ValidacaoException e, HttpServletRequest request) {

        DetalheErro erro = new DetalheErro(e.getMessage(), e.getStatus());

        return ResponseEntity.status(e.getStatus()).body(erro);
    }

}
