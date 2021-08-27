package br.com.zup.edu.sitedeviagens.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public PaisDto salvar(@RequestBody @Valid PaisForm paisForm) {
        Pais paisSalvo = paisRepository.save(paisForm.toModel());
        return PaisDto.modelToDto(paisSalvo);
    }
}
