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
 Configuração

1. Requisitos:
   - Java 17 ou superior
   - Maven (ou usar wrappers ./mvnw)
   - MySQL instalado e em execução

2. Clonar o repositório:
   
   git clone https://github.com/GabrielPeicher/Projeto-Estoque.git
   cd Projeto-Estoque/estoque

3. Configurar o banco de dados no arquivo application.properties:
```
   spring.datasource.url=jdbc:mysql://localhost:3306/estoque_db
   spring.datasource.username=root
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update
```

5. Executar a aplicação:
   
   ./mvnw spring-boot:run
   ou
   mvn spring-boot:run

6. Acessar a API em:
   
   http://localhost:8080
---

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

Exemplo POST:
```
{
  "nome": "Caderno",
  "descricao": "Caderno 200 folhas",
  "preco": 12.5,
  "quantidadeMinima": 5
}
```

<p align="center">
  <img src="https://github.com/RVitorFb/Projeto-Estoque/blob/main/insominia-testes.jpg?raw=true" alt="Banner Raul" width="100%" />
</p>

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

## 👨‍💻 Desenvolvido por

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/RVitorFb">
        <img src="https://github.com/RVitorFb.png" width="100px" style="border-radius: 50%;" alt="RVitorFb"/>
        <br />
        <sub><b>RVitorFb</b></sub>
      </a>
      <br />
      <a href="https://github.com/RVitorFb" title="GitHub">💻 Desenvolvedor</a>
    </td>
    <td align="center">
      <a href="https://github.com/GabrielPeicher">
        <img src="https://github.com/GabrielPeicher.png" pending-left="50px" width="100px" style="border-radius: 50%;" alt="GabrielPeicher"/>
        <br />
        <sub><b>Gabriel Peicher</b></sub>
      </a>
      <br />
      <a href="https://github.com/GabrielPeicher" title="GitHub">💻 Desenvolvedor</a>
    </td>
  </tr>
</table>

