package br.com.zup.edu.sitedeviagens.rota;

import br.com.zup.edu.sitedeviagens.aeroporto.Aeroporto;
import br.com.zup.edu.sitedeviagens.aeroporto.AeroportoRepository;
import br.com.zup.edu.sitedeviagens.commons.IdUnico;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class RotaForm {

    private String nome;

    @NotNull
    @IdUnico(domainClass = Aeroporto.class, fieldName = "id")
    private Long idAeroportoOrigem;

    @NotNull
    private Long idAeroportoDestino;

    @NotNull
    @Positive
    private Integer duracao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdAeroportoOrigem() {
        return idAeroportoOrigem;
    }

    public Long getIdAeroportoDestino() {
        return idAeroportoDestino;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Rota toModel(AeroportoRepository repository) {
        Aeroporto aeroportoOrigem = repository.findById(idAeroportoOrigem).orElseThrow(
                () -> new IllegalArgumentException("Esse aeroporto de origem não existe."));
        Aeroporto aeroportoDestino = repository.findById(idAeroportoDestino).orElseThrow(
                () -> new IllegalArgumentException("Esse aeroporto de destino não existe."));

        return new Rota(nome, aeroportoOrigem, aeroportoDestino, duracao);
    }
}
