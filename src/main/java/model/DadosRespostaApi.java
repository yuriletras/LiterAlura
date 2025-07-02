package com.literatura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosRespostaApi {
    // Mapeia a chave "results" do JSON para uma lista de objetos DadosLivro.
    @JsonAlias("results")
    private List<DadosLivro> livros;

    // Construtor padrão
    public DadosRespostaApi() {}

    // Getter para a lista de livros
    public List<DadosLivro> getLivros() {
        return livros;
    }

    // Setter para a lista de livros
    public void setLivros(List<DadosLivro> livros) {
        this.livros = livros;
    }
}