package br.com.zup.edu.sitedeviagens.compania;

import br.com.zup.edu.sitedeviagens.pais.Pais;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class CompanhiaForm {


    @NotBlank
    private String nome;

    @NotBlank
    private Pais pais;


    public Companhia toModel() {
        return new Companhia(this.nome, this.pais);
    }

}
