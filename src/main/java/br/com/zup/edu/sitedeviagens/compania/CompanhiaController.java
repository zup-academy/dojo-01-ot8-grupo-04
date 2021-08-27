package br.com.zup.edu.sitedeviagens.compania;

import br.com.zup.edu.sitedeviagens.pais.Pais;
import br.com.zup.edu.sitedeviagens.pais.PaisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class CompanhiaController {

    @Autowired
    private CompanhiaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid CompanhiaForm companhiaForm, UriComponentsBuilder uriBuilder) {
        Companhia companhia = repository.save(companhiaForm.toModel());
        URI uri = uriBuilder.path("/companhia/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(uri).body(companhia.toString());
    }


}
