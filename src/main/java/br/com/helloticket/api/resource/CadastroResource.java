package br.com.helloticket.api.resource;

import br.com.helloticket.api.model.Cadastro;
import br.com.helloticket.api.repository.CadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Cadastro> listar(){

        return cadastroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cadastro> criar(@RequestBody Cadastro cadastro, HttpServletResponse response){
        Cadastro cadastroSalva = cadastroRepository.save(cadastro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cadastro.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(cadastroSalva);
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
    public ResponseEntity<Cadastro> atualizar(@PathVariable long id, @RequestBody Cadastro cadastro){
        Cadastro cadastroSalva = cadastroRepository.findById(id);
        BeanUtils.copyProperties(cadastro, cadastroSalva, "id", "dataCadastro", "dataSituacao");
        cadastroRepository.save(cadastroSalva);
        return ResponseEntity.ok(cadastroSalva);
    }
}
