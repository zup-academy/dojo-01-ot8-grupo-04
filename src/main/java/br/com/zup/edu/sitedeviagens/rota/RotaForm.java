package br.com.zup.edu.sitedeviagens.rota;

import br.com.zup.edu.sitedeviagens.aeroporto.Aeroporto;
import br.com.zup.edu.sitedeviagens.aeroporto.AeroportoRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RotaForm {

    private String nome;

    @NotNull
    private Long idOrigem;

    @NotNull
    private Long idDestino;

    @NotNull
    @Positive
    private Integer duracao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdOrigem() {
        return idOrigem;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Rota toModel(AeroportoRepository repository) {
//        Aeroporto aeroportoOrigem =
//        return new Rota(nome, aeroportoOrigem, aeroportoDestino, duracao);
    }
}
