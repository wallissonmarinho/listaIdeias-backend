package br.com.helloticket.api.event.listener;

import br.com.helloticket.api.event.RecursoCriado;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoListener implements ApplicationListener<RecursoCriado> {


    @Override
    public void onApplicationEvent(RecursoCriado recursoCriado) {
        HttpServletResponse response = recursoCriado.getResponse();
        Long id = recursoCriado.getId();

        adicionarHeader(response, id);
    }

    private void adicionarHeader(HttpServletResponse response, Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
