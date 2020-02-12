package br.com.helloticket.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @NotNull
    @Size(min = 3, max = 50)
    private String descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Viabilidade viabilidade;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @NotNull
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "data_situacao")
    private LocalDate dataSituacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getViabilidade() {
        return viabilidade.getCode();
    }

    public void setViabilidade(Viabilidade viabilidade) {
        this.viabilidade = viabilidade;
    }

    public String getSituacao() {
        return situacao.getCode();
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataSituacao() {
        return dataSituacao;
    }

    public void setDataSituacao(LocalDate dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cadastro cadastro = (Cadastro) o;
        return Objects.equals(id, cadastro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

