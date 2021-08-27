package br.com.zup.edu.sitedeviagens.compania;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CompanhiaRepository repository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public CompanhiaDto salvar(@RequestBody @Valid CompanhiaForm companhiaForm) {
        Companhia companhia = repository.save(companhiaForm.toModel(entityManager));
        return CompanhiaDto.modelToDto(companhia);
    }

}
