package br.com.zup.edu.sitedeviagens.rota;

import br.com.zup.edu.sitedeviagens.aeroporto.Aeroporto;

public class RotaDto {

    private Long id;
    private String nome;
    private Aeroporto origem;
    private Aeroporto destino;
    private Integer duracao;

    public RotaDto(Long id, String nome, Aeroporto origem, Aeroporto destino, Integer duracao) {
        this.id = id;
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
