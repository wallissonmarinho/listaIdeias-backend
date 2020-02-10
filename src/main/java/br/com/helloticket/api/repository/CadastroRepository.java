package br.com.helloticket.api.repository;

import br.com.helloticket.api.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    Cadastro findById(long id);

}
