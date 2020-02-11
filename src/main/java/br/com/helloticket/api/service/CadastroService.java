package br.com.helloticket.api.service;

import br.com.helloticket.api.model.Cadastro;
import br.com.helloticket.api.repository.CadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro atualizar(long id, Cadastro cadastro){
        Cadastro cadastroSalva = cadastroRepository.findById(id);
        if (cadastroSalva == null){
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(cadastro, cadastroSalva, "id", "dataCadastro", "dataSituacao");
        return cadastroRepository.save(cadastroSalva);
    }
}
