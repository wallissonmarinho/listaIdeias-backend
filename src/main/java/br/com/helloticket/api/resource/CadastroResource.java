package br.com.helloticket.api.resource;

import br.com.helloticket.api.event.RecursoCriado;
import br.com.helloticket.api.model.Cadastro;
import br.com.helloticket.api.repository.CadastroRepository;
import br.com.helloticket.api.repository.filter.CadastroFilter;
import br.com.helloticket.api.service.CadastroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.PanelUI;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroResource {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    public List<Cadastro> pesquisar(CadastroFilter cadastroFilter){

        return cadastroRepository.filtrar(cadastroFilter);
    }

    @PostMapping
    public ResponseEntity<Cadastro> criar(@Valid @RequestBody Cadastro cadastro, HttpServletResponse response){
        Cadastro cadastroSalva = cadastroRepository.save(cadastro);
        publisher.publishEvent(new RecursoCriado(this, response, cadastroSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> findById(@PathVariable long id){
        Cadastro cadastro = cadastroRepository.findById(id);
        return cadastro != null ? ResponseEntity.ok(cadastro) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cadastro> delete(@PathVariable long id){
        cadastroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastro> atualizar(@PathVariable long id, @Valid @RequestBody Cadastro cadastro){
        Cadastro cadastroSalva = cadastroService.atualizar(id, cadastro);
        return ResponseEntity.ok(cadastroSalva);
    }
}
