package br.com.zup.edu.sitedeviagens.pais;

public class PaisDto {

    private Long id;
    private String nome;

    public static PaisDto modelToDto(Pais pais) {
        return new PaisDto(pais.getId(), pais.getNome());
    }

    public PaisDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
