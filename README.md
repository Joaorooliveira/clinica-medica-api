# API Clínica Médica - Voll.med 🩺

![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)
![Maven](https://img.shields.io/badge/Maven-blue.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

> 🚧 **API RESTful para o gerenciamento de uma clínica médica.** 🚧

Este projeto é uma API RESTful para a clínica fictícia "Voll.med". [cite_start]A aplicação permite o gerenciamento completo (CRUD) de médicos e pacientes [cite: 594, 752, 795, 802, 806][cite_start], incluindo seus dados cadastrais e endereços[cite: 369].

## 🚀 Funcionalidades Principais

A API oferece as seguintes funcionalidades:

* **Gestão de Médicos:**
    * [cite_start]Cadastro de novos médicos (com nome, email, CRM, especialidade e endereço)[cite: 796, 797, 807, 808].
    * [cite_start]Listagem de todos os médicos cadastrados[cite: 626].
    * Atualização de informações de médicos (como telefone e endereço).
    * [cite_start]Exclusão lógica de médicos (inativação)[cite: 243].
* **Gestão de Pacientes:**
    * [cite_start]Cadastro de novos pacientes (com nome, email, telefone, CPF e endereço)[cite: 597, 599].
    * [cite_start]Atualização de informações de pacientes (como nome, telefone e endereço)[cite: 752, 756].
    * Listagem e detalhamento de pacientes.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

* **[Java 17+](https://www.oracle.com/java/)**
* [cite_start]**[Spring Boot 3](https://spring.io/projects/spring-boot):** Framework principal para a criação da API.
* [cite_start]**[Spring Data JPA](https://spring.io/projects/spring-data-jpa):** Para persistência de dados e mapeamento objeto-relacional (ORM)[cite: 373].
* [cite_start]**[Maven](https://maven.apache.org/):** Gerenciador de dependências do projeto[cite: 775, 784].
* [cite_start]**[MySQL](https://www.mysql.com/):** Banco de dados relacional para armazenamento dos dados[cite: 784, 795].
* [cite_start]**[Flyway](https://flywaydb.org/):** Ferramenta para versionamento e migração de banco de dados (migrations).
* [cite_start]**[Lombok](https://projectlombok.org/):** Biblioteca para reduzir código boilerplate (como Getters, Setters e Construtores)[cite: 373].
* [cite_start]**[Spring Validation](https://docs.spring.io/):** Utilizado para validação dos dados de entrada (DTOs)[cite: 597, 598, 808].

## 🔌 API Endpoints

Os principais endpoints disponíveis na API são:

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/medicos` | [cite_start]Cadastra um novo médico[cite: 802]. |
| `GET` | `/medicos` | [cite_start]Lista todos os médicos[cite: 626]. |
| `PUT` | `/medicos` | Atualiza os dados de um médico. |
| `DELETE` | `/medicos/{id}` | [cite_start]Inativa um médico (exclusão lógica)[cite: 243]. |
| `POST` | `/pacientes` | [cite_start]Cadastra um novo paciente[cite: 594]. |
| `GET` | `/pacientes` | Lista todos os pacientes. |
| `PUT` | `/pacientes` | [cite_start]Atualiza os dados de um paciente[cite: 752]. |

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
