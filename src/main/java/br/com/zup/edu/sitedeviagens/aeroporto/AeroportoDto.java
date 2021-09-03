package br.com.zup.edu.sitedeviagens.aeroporto;

import br.com.zup.edu.sitedeviagens.pais.Pais;

import javax.persistence.ManyToOne;

public class AeroportoDto {

    private Long id;
    private String nome;
    private Pais pais;



    public AeroportoDto(Long id, String nome, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }


    public static AeroportoDto modelToDto(Aeroporto aeroporto) {
        return new AeroportoDto(aeroporto.getId(), aeroporto.getNome(), aeroporto.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
