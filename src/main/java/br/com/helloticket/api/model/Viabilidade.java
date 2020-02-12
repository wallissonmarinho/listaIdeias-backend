package br.com.helloticket.api.model;

public enum Viabilidade {
    BAIXA("1"),
    ABAIXO_DA_MEDIA("2"),
    MEDIA("3"),
    ACIMA_DA_MEDIA("4"),
    ALTA("5");

    private String code;

    Viabilidade(String code){ this.code = code; }

    public String getCode() {
        return code;
    }}
