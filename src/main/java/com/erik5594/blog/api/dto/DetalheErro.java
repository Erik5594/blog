package com.erik5594.blog.api.dto;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 08:35
 */
public class DetalheErro {

    private String mensagem;
    private int status;
    private long timestamp;

    public DetalheErro(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
