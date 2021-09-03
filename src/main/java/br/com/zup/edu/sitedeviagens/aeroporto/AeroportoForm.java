package br.com.zup.edu.sitedeviagens.aeroporto;

import br.com.zup.edu.sitedeviagens.commons.UniqueValue;
import br.com.zup.edu.sitedeviagens.compania.Companhia;
import br.com.zup.edu.sitedeviagens.pais.Pais;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportoForm {

    @NotBlank
    @UniqueValue(domainClass = Aeroporto.class, fieldName = "nome")
    private String nome;

    @NotNull
    private Long idPais;

    public Aeroporto toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.idPais);
        return new Aeroporto(this.nome, pais);
    }

    public AeroportoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }
}
