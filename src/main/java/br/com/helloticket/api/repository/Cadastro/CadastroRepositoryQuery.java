package br.com.helloticket.api.repository.Cadastro;

import br.com.helloticket.api.model.Cadastro;
import br.com.helloticket.api.repository.filter.CadastroFilter;

import java.util.List;

public interface CadastroRepositoryQuery {

    public List<Cadastro> filtrar(CadastroFilter cadastroFilter);
}
