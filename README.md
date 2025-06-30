\<div align="center"\>
\<h1\>ti-kolb\</h1\>
\<p\>
Serviço responsável por aplicar o teste de Estilos de Aprendizagem de Kolb para a aplicação Tutor Inteligente.
\</p\>

\<p\>
\<img alt="Versão do Java" src="[https://img.shields.io/badge/Java-17-blue?logo=openjdk\&logoColor=white](https://www.google.com/search?q=https://img.shields.io/badge/Java-17-blue%3Flogo%3Dopenjdk%26logoColor%3Dwhite)"\>
\<img alt="Versão do Spring Boot" src="[https://img.shields.io/badge/Spring\_Boot-3.5.0-brightgreen?logo=spring\&logoColor=white](https://www.google.com/search?q=https://img.shields.io/badge/Spring_Boot-3.5.0-brightgreen%3Flogo%3Dspring%26logoColor%3Dwhite)"\>
\</p\>
\</div\>

-----

## 📝 Índice

  - [Sobre o Projeto](https://www.google.com/search?q=%23-sobre-o-projeto)
  - [✨ Principais Funcionalidades](https://www.google.com/search?q=%23-principais-funcionalidades)
  - [🛠️ Tecnologias Utilizadas](https://www.google.com/search?q=%23%EF%B8%8F-tecnologias-utilizadas)
  - [🚀 Começando](https://www.google.com/search?q=%23-come%C3%A7ando)
      - [Pré-requisitos](https://www.google.com/search?q=%23pr%C3%A9-requisitos)
      - [Instalação e Execução](https://www.google.com/search?q=%23instala%C3%A7%C3%A3o-e-execu%C3%A7%C3%A3o)
  - [📖 Documentação da API](https://www.google.com/search?q=%23-documenta%C3%A7%C3%A3o-da-api)
  - [👤 Contato](https://www.google.com/search?q=%23-contato)

-----

## 🧐 Sobre o Projeto

Este projeto é o serviço **"Kolb"** para a aplicação "Tutor Inteligente". Sua principal responsabilidade é aplicar o teste de Estilos de Aprendizagem de Kolb, que pode ser realizado de forma parcial ou total. O serviço recebe o ID e o nome do usuário e, com base nas respostas fornecidas, calcula e determina o seu perfil de aprendizagem.

-----

## ✨ Principais Funcionalidades

  - Aplicação do teste de Kolb, de forma parcial ou completa.
  - Cálculo do perfil de aprendizagem do usuário com base nas respostas.
  - Recepção de dados do usuário (ID, nome) para iniciar o processo.
  - Integração com outros serviços através de mensageria com **RabbitMQ**.

-----

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 17** | Linguagem de programação principal. |
| **Spring Boot 3.5.0** | Framework para construção da aplicação, incluindo Web, Data JPA e Actuator. |
| **Spring AMQP** | Integração com o sistema de mensageria RabbitMQ. |
| **MySQL** | Banco de dados relacional para persistência dos dados. |
| **SpringDoc (Swagger)** | Documentação automática e interativa da API RESTful. |
| **Lombok** | Biblioteca para redução de código boilerplate. |
| **Jakarta Validation** | Validação dos dados de entrada da API. |
| **Jackson** | Biblioteca para manipulação de objetos JSON. |
| **Maven** | Gerenciador de dependências e build do projeto. |

-----

## 🚀 Começando

Siga estas instruções para ter uma cópia do projeto rodando na sua máquina local para desenvolvimento e testes.

### Pré-requisitos

  - **Java Development Kit (JDK) 17** ou superior.
  - **Maven 3.6** ou superior.
  - Uma instância do **MySQL** em execução.
  - Uma instância do **RabbitMQ** em execução.

### Instalação e Execução

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/bbering/ti-kolb
    cd ti-kolb
    ```

2.  **Configure o ambiente:**
    No arquivo `src/main/resources/application.properties`, configure as propriedades de conexão com seu banco de dados MySQL e com seu servidor RabbitMQ.

    ```properties
    # Exemplo para MySQL
    spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha

    # Exemplo para RabbitMQ
    spring.rabbitmq.host=localhost
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=guest
    spring.rabbitmq.password=guest
    ```

3.  **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

-----

## 📖 Documentação da API

Após iniciar o projeto, a documentação completa e interativa da API pode ser acessada via Swagger UI no seu navegador:

**🔗 [http://localhost:8080/swagger-ui.html](https://www.google.com/search?q=http://localhost:8080/swagger-ui.html)**

-----


## 👤 Contato

Link do Projeto: [https://github.com/bbering/ti-kolb](https://github.com/bbering/ti-kolb)