package br.com.zup.edu.sitedeviagens.rota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @PostMapping
    public RotaDto cadastrarRota(@RequestBody @Valid RotaForm form) {
        Rota rota = form.toModel();
        rota = rotaRepository.save(rota);
        return new RotaDto(rota.getId(), rota.getNome(), rota.getOrigem(), rota.getDestino(), rota.getDuracao());
    }

}
