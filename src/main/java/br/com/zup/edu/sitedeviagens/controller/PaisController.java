package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.model.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@ResponseBody @Valid PaisForm paisForm, Uri) {
        Pais paisSalvo = paisRepository.save(paisForm.toModel());
        return ResponseEntity.created()
    }
}
