package br.com.helloticket.api.repository.Cadastro;

import br.com.helloticket.api.model.Cadastro;
import br.com.helloticket.api.repository.filter.CadastroFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepositoryImpl implements CadastroRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cadastro> filtrar(CadastroFilter cadastroFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cadastro> criteria = builder.createQuery(Cadastro.class);
        Root<Cadastro> root = criteria.from(Cadastro.class);

        Predicate[] predicates = criarRestricoes(cadastroFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Cadastro> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(CadastroFilter cadastroFilter, CriteriaBuilder builder, Root<Cadastro> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(cadastroFilter.getSituacao())){
             predicates.add(builder.like(builder.lower(root.get("situacao")), "%" + cadastroFilter.getSituacao().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(cadastroFilter.getViabilidade())){
            predicates.add(builder.like(builder.lower(root.get("viabilidade")), "%" + cadastroFilter.getViabilidade().toLowerCase() + "%"));
        }


        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
