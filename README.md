# API Clínica Médica - Voll.med 🩺

![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)
![Maven](https://img.shields.io/badge/Maven-blue.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

> 🚧 **API RESTful para o gerenciamento de uma clínica médica.** 🚧

Este projeto é uma API RESTful para a clínica fictícia "Voll.med".A aplicação permite o gerenciamento completo (CRUD) de médicos e pacientes, incluindo seus dados cadastrais e endereços.

## 🚀 Funcionalidades Principais

A API oferece as seguintes funcionalidades:

* **Gestão de Médicos:**
    * Cadastro de novos médicos (com nome, email, CRM, especialidade e endereço).
    * Listagem de todos os médicos cadastrados.
    * Atualização de informações de médicos (como telefone e endereço).
    * Exclusão lógica de médicos (inativação).
* **Gestão de Pacientes:**
    * Cadastro de novos pacientes (com nome, email, telefone, CPF e endereço).
    * Atualização de informações de pacientes (como nome, telefone e endereço).
    * Listagem e detalhamento de pacientes.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

* **[Java 17+](https://www.oracle.com/java/)**
* **[Spring Boot 3](https://spring.io/projects/spring-boot):** Framework principal para a criação da API.
* **[Spring Data JPA](https://spring.io/projects/spring-data-jpa):** Para persistência de dados e mapeamento objeto-relacional (ORM).
* **[Maven](https://maven.apache.org/):** Gerenciador de dependências do projeto.
* **[MySQL](https://www.mysql.com/):** Banco de dados relacional para armazenamento dos dados.
* **[Flyway](https://flywaydb.org/):** Ferramenta para versionamento e migração de banco de dados (migrations).
* **[Lombok](https://projectlombok.org/):** Biblioteca para reduzir código boilerplate (como Getters, Setters e Construtores)[cite: 373].
* **[Spring Validation](https://docs.spring.io/):** Utilizado para validação dos dados de entrada (DTOs).

## 🔌 API Endpoints

Os principais endpoints disponíveis na API são:

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/medicos` | Cadastra um novo médico. |
| `GET` | `/medicos` | Lista todos os médicos. |
| `PUT` | `/medicos` | Atualiza os dados de um médico. |
| `DELETE` | `/medicos/{id}` | Inativa um médico (exclusão lógica). |
| `POST` | `/pacientes` | Cadastra um novo paciente. |
| `GET` | `/pacientes` | Lista todos os pacientes. |
| `PUT` | `/pacientes` | Atualiza os dados de um paciente. |

## ⚙️ Como Executar o Projeto

Siga os passos abaixo para executar a aplicação localmente:

1.  **Clone o repositório:**
    ```sh
    git clone [https://github.com/Joaorooliveira/clinica-medica-api.git](https://github.com/Joaorooliveira/clinica-medica-api.git)
    cd clinica-medica-api
    ```

2.  **Configure o Banco de Dados:**
    * Crie um banco de dados MySQL.
    * Configure as variáveis de ambiente ou altere o arquivo `src/main/resources/application.properties` com a URL do seu banco, usuário e senha.

3.  **Execute a Aplicação:**
    * Aguarde o Maven baixar as dependências.
    * Execute o projeto usando o Spring Boot:
    ```sh
    ./mvnw spring-boot:run
    ```
    * O Flyway executará as migrations automaticamente  para criar as tabelas.

4.  **Acesse a API:**
    * A API estará disponível em `http://localhost:8080`.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
