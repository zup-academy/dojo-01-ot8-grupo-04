package br.com.zup.edu.sitedeviagens.rota;

import br.com.zup.edu.sitedeviagens.aeroporto.Aeroporto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Rota {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;

    @NotNull
    @ManyToOne
    private Aeroporto origem;

    @NotNull
    @ManyToOne
    private Aeroporto destino;

    @Positive
    private Integer duracao;

    public Rota(String nome, Aeroporto origem, Aeroporto destino, Integer duracao) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public Integer getDuracao() {
        return duracao;
    }
}
