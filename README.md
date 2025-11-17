# Projeto Estoque - TJ Portas

Sistema de gerenciamento de estoque desenvolvido em Java 17+ utilizando Spring Boot, com API REST para cadastro de fornecedores, modelos, produtos e controle de quantidades em estoque, permitindo operações CRUD integradas e persistência em MySQL.

## Tecnologias Utilizadas

- Java 17 ou superior
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA (Acesso ao banco de dados)
- MySQL (Banco de dados relacional)
- Maven (Gerenciamento de dependências e build)
- Lombok (Redução de boilerplate em entidades)
- Insomnia (Testes e simulações de endpoints)

## Estrutura do Projeto

```
estoque/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/tjportas/estoque/
 │   │   │   ├── EstoqueApplication.java             # Classe principal da aplicação
 │   │   │   ├── controller/
 │   │   │   │   ├── FornecedorController.java       # Controller REST para Fornecedor
 │   │   │   │   ├── ModeloController.java          # Controller REST para Modelo
 │   │   │   │   ├── ProdutoController.java         # Controller REST para Produto
 │   │   │   │   └── EstoqueController.java         # Controller REST para Estoque
 │   │   │   ├── entity/
 │   │   │   │   ├── Fornecedor.java                # Entidade Fornecedor
 │   │   │   │   ├── Modelo.java                    # Entidade Modelo
 │   │   │   │   ├── Produto.java                   # Entidade Produto
 │   │   │   │   └── Estoque.java                   # Entidade Estoque
 │   │   │   └── repository/
 │   │   │       ├── FornecedorRepository.java      # Repositório JPA para Fornecedor
 │   │   │       ├── ModeloRepository.java          # Repositório JPA para Modelo
 │   │   │       ├── ProdutoRepository.java         # Repositório JPA para Produto
 │   │   │       └── EstoqueRepository.java         # Repositório JPA para Estoque
 │   │   └── resources/
 │   │       ├── application.properties            # Configurações da aplicação
 │   │       └── META-INF/
 │   └── test/java/com/tjportas/estoque/
 │       └── EstoqueApplicationTests.java          # Testes unitários
 ├── pom.xml                                       # Arquivo de configuração do Maven
 └── mvnw / mvnw.cmd                               # Wrappers do Maven
```

## Configuração

1. Requisitos:
   - Java 17 ou superior
   - Maven (ou usar wrappers ./mvnw)
   - MySQL instalado e em execução

2. Clonar o repositório:
   
   git clone https://github.com/GabrielPeicher/Projeto-Estoque.git
   cd Projeto-Estoque/estoque

4. Configurar o banco de dados no arquivo application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/estoque_db
   spring.datasource.username=root
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update

5. Executar a aplicação:
   
   ./mvnw spring-boot:run
   ou
   mvn spring-boot:run

6. Acessar a API em:
   
   http://localhost:8080

## Endpoints REST (Exemplo)

| Entidade   | Método | Endpoint         | Descrição                             |
| ---------- | ------ | ---------------- | ------------------------------------- |
| Fornecedor | GET    | /fornecedor      | Lista todos os fornecedores           |
| Fornecedor | POST   | /fornecedor      | Adiciona um novo fornecedor           |
| Fornecedor | PUT    | /fornecedor/{id} | Atualiza informações de um fornecedor |
| Fornecedor | DELETE | /fornecedor/{id} | Remove um fornecedor                  |
| Modelo     | GET    | /modelo          | Lista todos os modelos                |
| Modelo     | POST   | /modelo          | Adiciona um novo modelo               |
| Modelo     | PUT    | /modelo/{id}     | Atualiza informações de um modelo     |
| Modelo     | DELETE | /modelo/{id}     | Remove um modelo                      |
| Produto    | GET    | /produto         | Lista todos os produtos               |
| Produto    | POST   | /produto         | Adiciona um novo produto              |
| Produto    | PUT    | /produto/{id}    | Atualiza informações de um produto    |
| Produto    | DELETE | /produto/{id}    | Remove um produto                     |
| Estoque    | GET    | /estoque         | Lista todos os itens em estoque       |
| Estoque    | POST   | /estoque         | Adiciona um novo item ao estoque      |
| Estoque    | PUT    | /estoque/{id}    | Atualiza informações do estoque       |
| Estoque    | DELETE | /estoque/{id}    | Remove um item do estoque             |

Todos os retornos estão em formato JSON.

## Testes e Simulações

Testes realizados no Insomnia para todas as entidades:
POST → criação de registros
GET → listagem
PUT → atualização
DELETE → exclusão

<p align="center">
  <img src="https://github.com/RVitorFb/Projeto-Estoque/blob/main/insominia-testes.jpg?raw=true" alt="Banner Raul" width="100%" />
</p>

Confirmação da persistência de dados no MySQL.

## Licença

Este projeto é distribuído sob a licença MIT.
