package br.com.helloticket.api.model;

public enum Situacao {
    REGISTRADA("Registrada"),
    DESENVOLVIMENTO("Em Desenvolvimento"),
    CANCELADA("Cancelada"),
    DESENVOLVIDA("Desenvolvida");

    private String code;

    Situacao(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
