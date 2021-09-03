package br.com.zup.edu.sitedeviagens.compania;

import br.com.zup.edu.sitedeviagens.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @ManyToOne
    private Pais pais;

    @NotBlank
    private LocalDateTime createdAt = LocalDateTime.now();

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Companhia() {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Companhia{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
