# ti-kolb

## Descrição

Este projeto é o serviço "Kolb" para a aplicação "Tutor Inteligente". Sua principal responsabilidade é aplicar o teste de Estilos de Aprendizagem de Kolb, que pode ser realizado de forma parcial ou total. O serviço recebe o ID e o nome do usuário e, com base nas respostas fornecidas, calcula e determina o seu perfil de aprendizagem.

## Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias e bibliotecas principais:

  * **Java 17**
  * **Spring Boot 3.5.0**
      * **Spring Web:** Para a criação de APIs RESTful.
      * **Spring Data JPA:** Para a persistência de dados com o banco de dados.
      * **Spring Boot Actuator:** Para monitoramento e gerenciamento da aplicação.
      * **Spring AMQP:** Para integração com o RabbitMQ e troca de mensagens.
  * **MySQL:** O projeto está configurado para se conectar a um banco de dados MySQL em tempo de execução.
  * **Lombok:** Para reduzir a quantidade de código boilerplate (getters, setters, construtores, etc.).
  * **SpringDoc OpenAPI (Swagger):** Para a documentação automática da API.
  * **Jakarta Validation:** Para a validação dos dados de entrada.
  * **Jackson:** Para o tratamento eficiente de objetos JSON.

## Pré-requisitos

Antes de executar o projeto, certifique-se de que você tem os seguintes softwares instalados em sua máquina:

  * JDK 17 ou superior
  * Maven 3.6 ou superior
  * Uma instância do MySQL em execução
  * Uma instância do RabbitMQ em execução

## Como Executar o Projeto

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/bbering/ti-kolb
    cd ti-kolb
    ```

2.  **Configure o banco de dados e o RabbitMQ:**
    Abra o arquivo `src/main/resources/application.properties` e configure as propriedades de conexão com o seu banco de dados MySQL e com o seu servidor RabbitMQ.

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

3.  **Execute a aplicação com o Maven:**
    Você pode iniciar a aplicação utilizando o plugin do Spring Boot para o Maven:

    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Documentação da API

Este projeto utiliza o **SpringDoc** para gerar a documentação da API em tempo real. Após iniciar a aplicação, você pode acessar a interface do Swagger UI no seguinte endereço:

[http://localhost:8080/swagger-ui.html](https://www.google.com/search?q=http://localhost:8080/swagger-ui.html)

Lá você encontrará todos os *endpoints* disponíveis, com seus respectivos parâmetros, e poderá testá-los diretamente pelo navegador.