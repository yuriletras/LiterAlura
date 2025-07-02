package com.literatura.literAlura.service; // Crie uma pasta 'service' para isso!

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        // HttpClient: É como um navegador web dentro do seu código Java.
        // Ele é usado para enviar requisições HTTP e receber respostas.
        HttpClient client = HttpClient.newHttpClient();

        // HttpRequest: Define o que você quer pedir. Qual URL? Qual método (GET, POST)?
        // Aqui, estamos construindo uma requisição GET para o 'endereco' fornecido.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)) // Converte a string do endereço em um objeto URI.
                .build(); // Finaliza a construção da requisição.

        // HttpResponse: O que você recebe de volta da requisição.
        // Contém o corpo da resposta (o JSON, neste caso), o código de status (200 OK, 404 Not Found), etc.
        HttpResponse<String> response = null;
        try {
            // client.send: Envia a requisição e espera pela resposta.
            // HttpResponse.BodyHandlers.ofString(): Indica que queremos o corpo da resposta como uma String.
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // Erros de I/O (rede, etc.) ou se a thread for interrompida durante a requisição.
            throw new RuntimeException("Erro ao consumir a API: " + e.getMessage(), e);
        }

        // Pega o corpo da resposta, que é o nosso JSON.
        String json = response.body();
        return json;
    }
}