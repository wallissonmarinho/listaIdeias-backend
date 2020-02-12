package br.com.helloticket.api.repository.filter;

public class CadastroFilter {

    private String situacao;
    private String viabilidade;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getViabilidade() {
        return viabilidade;
    }

    public void setViabilidade(String viabilidade) {
        this.viabilidade = viabilidade;
    }
}
