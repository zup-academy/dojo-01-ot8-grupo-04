package br.com.zup.edu.sitedeviagens.pais;

import javax.validation.constraints.NotEmpty;

public class PaisForm {

    @NotEmpty
    private String nome;

    public PaisForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
