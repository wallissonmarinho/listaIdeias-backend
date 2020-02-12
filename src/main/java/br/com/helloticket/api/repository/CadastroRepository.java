package br.com.helloticket.api.repository;

import br.com.helloticket.api.model.Cadastro;
import br.com.helloticket.api.repository.Cadastro.CadastroRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>, CadastroRepositoryQuery {

    Cadastro findById(long id);

}
