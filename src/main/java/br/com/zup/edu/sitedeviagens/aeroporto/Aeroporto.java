package br.com.zup.edu.sitedeviagens.aeroporto;

import br.com.zup.edu.sitedeviagens.pais.Pais;

import javax.persistence.*;

@Entity
public class Aeroporto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Aeroporto() {
    }

    public Aeroporto(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
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
