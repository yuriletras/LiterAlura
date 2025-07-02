# LiterAlura - Catálogo de Livros via API e Banco de Dados

## Índice
* [Sobre o Projeto](#sobre-o-projeto)
* [Funcionalidades](#funcionalidades)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Como Rodar o Projeto](#como-rodar-o-projeto)
    * [Pré-requisitos](#pré-requisitos)
    * [Configuração do Banco de Dados PostgreSQL](#configuração-do-banco-de-dados-postgresql)
    * [Configuração do Projeto](#configuração-do-projeto)
    * [Execução da Aplicação](#execução-da-aplicação)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Contribuições](#contribuições)
* [Autor](#autor)

---

## Sobre o Projeto

O LiterAlura é uma aplicação Java desenvolvida como parte de um desafio de programação, que permite aos usuários buscar informações sobre livros através de uma API externa (Gutendex), visualizar detalhes e persistir esses dados em um banco de dados PostgreSQL. O projeto oferece uma interação textual via console, proporcionando uma experiência de catálogo de livros simples e eficaz, com foco em uma boa experiência de usuário através de mensagens claras e tratamento de erros.

---

## Funcionalidades

O LiterAlura oferece as seguintes opções de interação via console:

1.  **Buscar livro por título:** Permite ao usuário pesquisar um livro na API Gutendex e, se encontrado, salva os detalhes do livro e seu(s) autor(es) no banco de dados local. A aplicação verifica se o livro já existe antes de salvá-lo.
2.  **Listar todos os livros buscados:** Exibe uma lista de todos os livros que já foram salvos no banco de dados, com detalhes formatados.
3.  **Listar autores vivos em um determinado ano:** Apresenta todos os autores cadastrados que estavam vivos durante um ano específico fornecido pelo usuário.
4.  **Listar livros por idioma:** Filtra e exibe os livros salvos no banco de dados com base no código do idioma especificado (ex: "en" para inglês, "es" para espanhol, "pt" para português).
5.  **Listar todos os autores:** Exibe uma lista completa de todos os autores cujos livros foram salvos no banco de dados, juntamente com os livros associados a cada autor.
6.  **Saída:** Encerra a aplicação.

---

## Tecnologias Utilizadas

* **Java 17 (JDK):** Linguagem de programação principal.
* **Spring Boot 3.2.3:** Framework para construir aplicações Java robustas e escaláveis.
* **Spring Data JPA:** Simplifica a interação com o banco de dados.
* **PostgreSQL 16+:** Sistema de gerenciamento de banco de dados relacional.
* **Maven:** Ferramenta para automação da construção e gerenciamento de dependências.
* **Jackson:** Biblioteca para serialização/desserialização de JSON em Java.
* **IntelliJ IDEA:** Ambiente de Desenvolvimento Integrado (IDE) recomendado.

---

## Como Rodar o Projeto

Siga os passos abaixo para configurar e executar o LiterAlura em sua máquina.

### Pré-requisitos

Certifique-se de ter instalado:
* **Java JDK 17** ou superior (verifique com `java -version` no terminal).
* **Apache Maven** (verifique com `mvn -v` no terminal).
* **PostgreSQL 16** ou superior (servidor de banco de dados).
* **pgAdmin 4** (ferramenta gráfica para gerenciar o PostgreSQL).
* **IntelliJ IDEA Community Edition** (ou outra IDE Java de sua preferência).

### Configuração do Banco de Dados PostgreSQL

1.  Se você ainda não tem o PostgreSQL instalado, siga as instruções em [postgresql.org/download/](https://www.postgresql.org/download/) para baixar e instalar a versão 16+. Lembre-se de anotar a **senha** definida para o usuário padrão `postgres`.
2.  Abra o **pgAdmin 4**.
3.  Conecte-se ao seu servidor PostgreSQL (geralmente `PostgreSQL 16` ou similar no painel esquerdo) usando o usuário `postgres` e a senha que você definiu na instalação.
4.  No painel esquerdo, clique com o botão direito em **`Databases`** e selecione **`Create` > `Database...`**.
5.  No campo **`Database`**, digite `literAlura` (exatamente este nome).
6.  Clique em **`Save`** para criar o banco de dados.

### Configuração do Projeto

1.  **Baixe ou clone o projeto:**
    * Se você gerou o projeto pelo Spring Initializr, descompacte o arquivo ZIP em um diretório de sua escolha.
    * Se for clonar de um repositório Git:
        ```bash
        git clone <URL_DO_SEU_REPOSITORIO>
        ```
2.  **Abra o projeto no IntelliJ IDEA:**
    * No IntelliJ, selecione `File > Open...` e navegue até a pasta raiz do projeto `literAlura`.
    * O IntelliJ irá detectar o `pom.xml` e importar as dependências Maven automaticamente.
3.  **Configure o `application.properties`:**
    * Navegue até `src/main/resources/application.properties`.
    * Atualize as credenciais do banco de dados para corresponder ao seu usuário (`postgres`) e à senha que você definiu durante a instalação do PostgreSQL:

        ```properties
        # Configurações do Banco de Dados PostgreSQL
        spring.datasource.url=jdbc:postgresql://localhost:5432/literAlura
        spring.datasource.username=postgres               # Seu usuário PostgreSQL
        spring.datasource.password=SUA_SENHA_DO_POSTGRES # A senha que você definiu
        spring.datasource.driver-class-name=org.postgresql.Driver

        # Configurações do JPA/Hibernate
        spring.jpa.hibernate.ddl-auto=update             # O Hibernate cria/atualiza as tabelas automaticamente
        spring.jpa.show-sql=true                         # Exibe as queries SQL no console
        spring.jpa.properties.hibernate.format_sql=true  # Formata as queries SQL
        ```
    * **Salve** o arquivo `application.properties`.
    * Clique no ícone do Maven no IntelliJ (geralmente um "M" com setas circulares) para **recarregar as mudanças** nas dependências e configurações.

### Execução da Aplicação

1.  No IntelliJ IDEA, navegue até a classe principal `LiterAluraApplication.java` (localizada em `src/main/java/com/literatura/literAlura`).
2.  Clique no botão **"Run"** (o triângulo verde) ao lado do método `main` ou na barra de ferramentas superior.
3.  A aplicação será iniciada e o menu de interação será exibido no console do IntelliJ. Siga as instruções no menu para interagir com o catálogo de livros.

---

## Estrutura do Projeto

```
literAlura/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── literatura/
│   │   │           └── literAlura/
│   │   │               ├── LiterAluraApplication.java  (Classe principal do Spring Boot que inicia a aplicação)
│   │   │               ├── model/                      (Classes que representam os dados e entidades do banco de dados)
│   │   │               │   ├── Autor.java              (Entidade JPA para autores no DB)
│   │   │               │   ├── DadosAutor.java         (DTO para mapear dados de autor da API)
│   │   │               │   ├── DadosLivro.java         (DTO para mapear dados de livro da API)
│   │   │               │   ├── DadosRespostaApi.java   (DTO para mapear a resposta global da API)
│   │   │               │   └── Livro.java              (Entidade JPA para livros no DB)
│   │   │               ├── principal/                  (Lógica de interação com o usuário via console)
│   │   │               │   └── Principal.java
│   │   │               ├── repository/                 (Interfaces para operações CRUD no DB com Spring Data JPA)
│   │   │               │   ├── AutorRepository.java
│   │   │               │   └── LivroRepository.java
│   │   │               └── service/                    (Classes para consumo de API e conversão de dados JSON)
│   │   │                   ├── ConsumoApi.java
│   │   │                   ├── ConverteDados.java
│   │   │                   └── IConverteDados.java
│   │   └── resources/
│   │       └── application.properties                  (Arquivo de configuração do Spring Boot e banco de dados)
│   └── test/                                           (Pacote para testes unitários/de integração)
├── .gitignore                                          (Arquivos e pastas a serem ignorados pelo Git)
├── pom.xml                                             (Arquivo de configuração do Maven para gerenciamento de dependências)
└── README.md                                           (Este arquivo)
```

---

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para propor melhorias, corrigir bugs ou adicionar novas funcionalidades.

---

## Autor

Yuri Barbosa
[https://github.com/yuriletras]
