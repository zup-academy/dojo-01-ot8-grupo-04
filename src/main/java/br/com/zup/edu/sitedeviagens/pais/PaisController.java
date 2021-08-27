package br.com.zup.edu.sitedeviagens.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid PaisForm paisForm, UriComponentsBuilder uriBuilder) {
        Pais paisSalvo = paisRepository.save(paisForm.toModel());
        URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(paisSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(paisSalvo.toString());
    }
}
