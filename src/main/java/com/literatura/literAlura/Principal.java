package com.literatura.literAlura.principal;

import com.literatura.literAlura.model.DadosLivro;
import com.literatura.literAlura.model.DadosRespostaApi;
import com.literatura.literAlura.service.ConsumoApi;
import com.literatura.literAlura.service.ConverteDados;
import org.springframework.stereotype.Component; // Importante para o Spring reconhecer como um componente

import java.util.InputMismatchException; // Para tratar entrada inválida
import java.util.Scanner;

@Component // Anotação que indica que esta classe é um componente do Spring e pode ser gerenciada/injetada
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    // Endereço base da API Gutendex
    private final String ENDERECO_API = "https://gutendex.com/books/";

    public void exibirMenu() {
        var opcao = -1; // Variável para a opção do menu, inicializada com um valor que não sai do loop

        while (opcao != 0) { // Loop principal do menu
            var menu = """
                    *** Escolha uma opção ***
                    1 - Buscar livro por título
                    2 - Listar todos os livros buscados
                    3 - Listar autores vivos em um determinado ano
                    4 - Listar livros por idioma
                    5 - Listar todos os autores
                    0 - Sair
                    """;
            System.out.println(menu);

            try {
                opcao = teclado.nextInt(); // Lê a opção digitada pelo usuário
                teclado.nextLine(); // Consome a quebra de linha que fica no buffer do teclado após nextInt()

                switch (opcao) {
                    case 1:
                        buscarLivroPorTitulo();
                        break;
                    case 2:
                        System.out.println("Funcionalidade em desenvolvimento: Listar todos os livros buscados.");
                        // futura chamada: listarTodosOsLivros();
                        break;
                    case 3:
                        System.out.println("Funcionalidade em desenvolvimento: Listar autores vivos em um determinado ano.");
                        // futura chamada: listarAutoresVivosPorAno();
                        break;
                    case 4:
                        System.out.println("Funcionalidade em desenvolvimento: Listar livros por idioma.");
                        // futura chamada: listarLivrosPorIdioma();
                        break;
                    case 5:
                        System.out.println("Funcionalidade em desenvolvimento: Listar todos os autores.");
                        // futura chamada: listarTodosOsAutores();
                        break;
                    case 0:
                        System.out.println("Saindo da aplicação. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Captura o erro se o usuário digitar algo que não é um número
                System.out.println("Entrada inválida. Por favor, digite um número correspondente à opção.");
                teclado.nextLine(); // Limpa o buffer para evitar loop infinito
            }
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Digite o título do livro para buscar:");
        var tituloLivro = teclado.nextLine(); // Lê o título digitado

        // Constrói a URL da API, substituindo espaços por %20 para URL encoding
        String url = ENDERECO_API + "?search=" + tituloLivro.replace(" ", "%20");
        System.out.println("Buscando em: " + url); // Para depuração

        // 1. Consome a API: Obtém o JSON da API.
        var json = consumo.obterDados(url);
        // System.out.println("JSON recebido: " + json); // Descomente para ver o JSON completo

        try {
            // 2. Converte os dados: Mapeia o JSON para o objeto DadosRespostaApi
            DadosRespostaApi dados = conversor.obterDados(json, DadosRespostaApi.class);

            // Verifica se a busca retornou algum livro
            if (dados != null && dados.getLivros() != null && !dados.getLivros().isEmpty()) {
                // Pega o primeiro livro da lista de resultados (conforme o desafio)
                DadosLivro livroEncontrado = dados.getLivros().get(0);
                System.out.println("--- Livro Encontrado da API ---");
                System.out.println(livroEncontrado);
                // Futuramente: aqui você chamará o método para salvar este livro no banco de dados.
            } else {
                System.out.println("Livro não encontrado com o título: '" + tituloLivro + "'.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao processar a busca do livro: " + e.getMessage());
            // e.printStackTrace(); // Descomente para ver o stack trace completo do erro
        }
    }
}