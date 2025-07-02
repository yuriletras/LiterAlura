package com.literatura.literAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // Importante: da biblioteca Jackson

public class ConverteDados implements IConverteDados {
    // ObjectMapper: É a classe principal da Jackson.
    // Ela é responsável por realizar a mágica de converter JSON para objetos Java
    // e vice-versa.
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // mapper.readValue(): Este é o método mágico!
            // Ele pega a String 'json' e tenta "ler" os dados nela,
            // mapeando-os para uma instância da 'classe' que você forneceu.
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            // Se houver algum problema no mapeamento (JSON inválido, campos não encontrados, etc.)
            // uma exceção JsonProcessingException é lançada.
            throw new RuntimeException("Erro ao converter dados JSON: " + e.getMessage(), e);
        }
    }
}