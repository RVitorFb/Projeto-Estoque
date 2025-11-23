# Projeto-Estoque

Um sistema de controle de estoque desenvolvido em Spring Boot (Java), permitindo gerenciamento de produtos, entradas e saídas e consultas de estoque.

## Visão Geral

O Projeto-Estoque é uma API REST criada para prática e uso real em sistemas de controle de estoque. Permite CRUD de produtos, movimentações e relatórios simples.

---

## Funcionalidades

- Cadastro de produtos
- Atualização e remoção
- Registro de entradas e saídas
- Relatório de estoque atual
- Validações básicas

---

## Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Banco de dados (MySQL, H2, PostgreSQL etc)
- Lombok (opcional)

---

## Arquitetura

- Controller — Endpoints REST
- Service — Regras de negócio (caso usado)
- Repository — Comunicação com o banco
- Entity — Mapear tabelas do banco

---

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

---

## Pré-requisitos

Para rodar o projeto, instale:

- Java JDK
- Maven
- Banco de dados configurado
- Ferramenta de testes REST (Postman, Insomnia)

---

## Como rodar o projeto

git clone https://github.com/GabrielPeicher/Projeto-Estoque
cd Projeto-Estoque
mvn clean install
mvn spring-boot:run

Aplicação iniciará em:

http://localhost:8080

---

## Configuração do application.properties

Exemplo:

spring.datasource.url=jdbc:mysql://localhost:3306/estoque
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

## Endpoints da API

### Produtos

GET /produtos  
Lista todos os produtos

GET /produtos/{id}  
Busca por ID

POST /produtos  
Cria produto

PUT /produtos/{id}  
Atualiza produto

DELETE /produtos/{id}  
Deleta produto

Exemplo POST:

{
  "nome": "Caderno",
  "descricao": "Caderno 200 folhas",
  "preco": 12.5,
  "quantidadeMinima": 5
}

<p align="center">
  <img src="https://github.com/RVitorFb/Projeto-Estoque/blob/main/insominia-testes.jpg?raw=true" alt="Banner Raul" width="100%" />
</p>

---

### Movimentações

POST /estoque/entrada  
Registra entrada

POST /estoque/saida  
Registra saída

Exemplo:

{
  "produtoId": 1,
  "quantidade": 10
}

---

### Relatórios

GET /estoque/atual  
Retorna o estoque atual de todos os produtos

---

## Testes

Executar:

mvn test

---

## Melhorias Futuras

- Swagger / OpenAPI
- Autenticação (Spring Security)
- Interface frontend
- Exportar relatórios (CSV / PDF)
- Sistema de alertas (estoque baixo)

---

## Contribuição

1. Fork o projeto  
2. Crie uma branch (git checkout -b minha-feature)  
3. Commit (git commit -m "Feature X")  
4. Push (git push origin minha-feature)  
5. Abra um Pull Request  

---

## Licença

Escolha ou adicione uma licença (MIT recomendado).

---

## Autor

RVitorFb  
GitHub: https://github.com/RVitorFb
