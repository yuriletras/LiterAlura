package com.literatura.literAlura.service;

public interface IConverteDados {
    // Método genérico que pega uma String JSON e uma classe de destino (T),
    // e retorna um objeto dessa classe com os dados mapeados do JSON.
    <T> T obterDados(String json, Class<T> classe);
}