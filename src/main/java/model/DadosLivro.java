package com.literatura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// @JsonIgnoreProperties(ignoreUnknown = true): Diz ao Jackson para ignorar
// quaisquer campos no JSON que não tenham um atributo correspondente nesta classe.
// Isso evita erros se a API retornar mais dados do que precisamos.
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosLivro {
    // @JsonAlias("title"): Mapeia o campo JSON "title" para o atributo 'titulo' da nossa classe.
    @JsonAlias("title")
    private String titulo;

    // Um livro pode ter vários autores na API, então é uma lista.
    @JsonAlias("authors")
    private List<DadosAutor> autores; // Veremos DadosAutor logo abaixo

    // Um livro pode ter vários idiomas na API, então é uma lista.
    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("download_count")
    private Integer numeroDownloads;

    // Construtor padrão (geralmente necessário para o Jackson)
    public DadosLivro() {}

    // Getters e Setters: Permitem acessar e modificar os valores dos atributos.
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public List<DadosAutor> getAutores() { return autores; }
    public void setAutores(List<DadosAutor> autores) { this.autores = autores; }
    public List<String> getIdiomas() { return idiomas; }
    public void setIdiomas(List<String> idiomas) { this.idiomas = idiomas; }
    public Integer getNumeroDownloads() { return numeroDownloads; }
    public void setNumeroDownloads(Integer numeroDownloads) { this.numeroDownloads = numeroDownloads; }

    // toString(): Útil para imprimir o objeto de forma legível no console.
    @Override
    public String toString() {
        // Consideramos apenas o primeiro autor e primeiro idioma, conforme o desafio.
        String autorNome = (autores != null && !autores.isEmpty()) ? autores.get(0).getNome() : "Desconhecido";
        String idiomaPrincipal = (idiomas != null && !idiomas.isEmpty()) ? idiomas.get(0) : "Desconhecido";

        return String.format("----- LIVRO API -----%nTitulo: %s%nAutor: %s%nIdioma: %s%nDownloads: %d%n-----------------%n",
                titulo, autorNome, idiomaPrincipal, numeroDownloads);
    }
}