package com.literatura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosAutor {
    @JsonAlias("name")
    private String nome;
    @JsonAlias("birth_year")
    private Integer anoNascimento;
    @JsonAlias("death_year")
    private Integer anoFalecimento;

    // Construtor padrão
    public DadosAutor() {}

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getAnoNascimento() { return anoNascimento; }
    public void setAnoNascimento(Integer anoNascimento) { this.anoNascimento = anoNascimento; }
    public Integer getAnoFalecimento() { return anoFalecimento; }
    public void setAnoFalecimento(Integer anoFalecimento) { this.anoFalecimento = anoFalecimento; }

    // toString()
    @Override
    public String toString() {
        return String.format("Nome: %s, Ano Nascimento: %d, Ano Falecimento: %d",
                nome, anoNascimento != null ? anoNascimento : "N/A", anoFalecimento != null ? anoFalecimento : "N/A");
    }
}