# Projeto Estoque

Sistema de gerenciamento de estoque desenvolvido em Java utilizando o Spring Boot, com suporte a operações CRUD para produtos e controle de quantidades em estoque.

## Tecnologias Utilizadas

- Java 17 ou superior
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA (Acesso ao banco de dados)
- Maven (Gerenciamento de dependências e build)

## Estrutura do Projeto

estoque/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/tjportas/estoque/
 │   │   │   ├── EstoqueApplication.java         # Classe principal da aplicação
 │   │   │   ├── controller/
 │   │   │   │   └── estoqueController.java      # Controlador REST para operações de estoque
 │   │   │   ├── entity/
 │   │   │   │   ├── Estoque.java                # Entidade Estoque
 │   │   │   │   └── Produto.java                # Entidade Produto
 │   │   │   └── repository/
 │   │   │       └── EstoqueRepository.java      # Repositório JPA para Estoque
 │   │   └── resources/
 │   │       ├── application.properties          # Configurações da aplicação
 │   │       └── META-INF/
 │   └── test/java/com/tjportas/estoque/
 │       └── EstoqueApplicationTests.java        # Testes unitários
 ├── pom.xml                                     # Arquivo de configuração do Maven
 └── mvnw / mvnw.cmd                             # Wrappers do Maven

## Configuração

1. Requisitos:
   - Java 17 ou superior instalado
   - Maven (opcional se usar os wrappers mvnw)

2. Clonar o repositório:
   git clone https://github.com/seu-usuario/Projeto-Estoque.git
   cd Projeto-Estoque/estoque

3. Configurar o banco de dados no arquivo application.properties, se necessário.

4. Executar a aplicação:
   ./mvnw spring-boot:run
   ou
   mvn spring-boot:run

5. Acessar a API em:
   http://localhost:8080

## Endpoints REST (Exemplo)

| Método | Endpoint      | Descrição                          |
|--------|---------------|------------------------------------|
| GET    | /estoque      | Lista todos os produtos em estoque |
| POST   | /estoque      | Adiciona um novo produto           |
| PUT    | /estoque/{id} | Atualiza informações de um produto |
| DELETE | /estoque/{id} | Remove um produto do estoque       |

(Os endpoints podem variar conforme a implementação.)

## Testes

Para executar os testes automatizados:
   ./mvnw test

## Licença

Este projeto é distribuído sob a licença MIT.
