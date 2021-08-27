package br.com.zup.edu.sitedeviagens.compania;

import br.com.zup.edu.sitedeviagens.pais.Pais;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class CompanhiaDto {

    private Long id;
    private String nome;
    private Pais pais;
    private LocalDateTime createdAt;

    public static CompanhiaDto modelToDto(Companhia companhia) {
        return new CompanhiaDto(companhia.getId(), companhia.getNome(), companhia.getPais(), companhia.getCreatedAt());
    }

    public CompanhiaDto(Long id, String nome, Pais pais, LocalDateTime createdAt) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.createdAt = createdAt;
    }
}
