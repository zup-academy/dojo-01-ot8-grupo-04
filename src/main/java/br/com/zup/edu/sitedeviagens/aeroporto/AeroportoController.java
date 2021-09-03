package br.com.zup.edu.sitedeviagens.aeroporto;

import br.com.zup.edu.sitedeviagens.compania.Companhia;
import br.com.zup.edu.sitedeviagens.compania.CompanhiaDto;
import br.com.zup.edu.sitedeviagens.compania.CompanhiaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public AeroportoDto salvar(@RequestBody @Valid AeroportoForm aeroportoForm) {
        Aeroporto aeroporto = aeroportoRepository.save(aeroportoForm.toModel(entityManager));
        return AeroportoDto.modelToDto(aeroporto);
    }
}
