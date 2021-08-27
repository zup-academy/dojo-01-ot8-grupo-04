package br.com.zup.edu.sitedeviagens.compania;

import br.com.zup.edu.sitedeviagens.commons.UniqueValue;
import br.com.zup.edu.sitedeviagens.pais.Pais;
import br.com.zup.edu.sitedeviagens.pais.PaisRepository;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class CompanhiaForm {


    @NotBlank
    private String nome;

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public Companhia toModel(EntityManager em) {
        Pais pais = em.find(Pais.class, this.idPais);
        return new Companhia(this.nome, pais);
    }

}
