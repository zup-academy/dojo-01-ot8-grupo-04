package br.com.zup.edu.sitedeviagens.rota;

import br.com.zup.edu.sitedeviagens.aeroporto.AeroportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @PostMapping
    public RotaDto cadastrarRota(@RequestBody @Valid RotaForm form) {
        Rota rota = form.toModel(aeroportoRepository);
        rota = rotaRepository.save(rota);
        return new RotaDto(rota.getId(), rota.getNome(), rota.getOrigem(), rota.getDestino(), rota.getDuracao());
    }

}
