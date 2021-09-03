package br.com.zup.edu.sitedeviagens.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
