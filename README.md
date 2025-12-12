# API Clínica Médica - Voll.med 🩺

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-green.svg)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-green.svg)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-brightgreen.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

> 🚧 **API RESTful completa para o gerenciamento de uma clínica médica.** 🚧

Este projeto é uma API RESTful desenvolvida para a clínica fictícia "Voll.med". A aplicação vai além do CRUD básico,
implementando regras de negócio complexas para agendamento de consultas, autenticação/autorização via Tokens JWT,
validações de integridade, testes automatizados e documentação interativa.

## 🚀 Funcionalidades Principais

A API oferece as seguintes funcionalidades:

* **🔐 Autenticação e Segurança:**
    * Login de utilizadores com geração de Token JWT (JSON Web Token).
    * Controlo de acesso às rotas (apenas utilizadores autenticados).
    * Hashing de passwords com BCrypt.

* **🩺 Gestão de Médicos:**
    * Cadastro, listagem (com paginação), atualização e exclusão lógica (inativação) de médicos.
    * Busca de médicos ativos.

* **Gestão de Pacientes:**
    * Cadastro, listagem, atualização e inativação de pacientes.

* **📅 Gestão de Consultas:**
    * **Agendamento:** Permite marcar consultas com validações automáticas de regras de negócio (SOLID).
    * **Cancelamento:** Permite cancelar consultas com justificativa, também sujeito a validações.
    * **Regras de Negócio Implementadas:**
        * Verificação de horário de funcionamento (07:00 às 19:00, seg-sab).
        * Antecedência mínima de 30 minutos para agendar.
        * Antecedência mínima de 24 horas para cancelar.
        * Verificação de médico/paciente ativo.
        * Verificação se o médico já possui consulta no mesmo horário.
        * Verificação se o paciente já possui consulta no mesmo dia.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

* **[Java 21](https://www.oracle.com/java/):** Linguagem de programação (versão LTS mais recente).
* **[Spring Boot 3](https://spring.io/projects/spring-boot):** Framework principal.
* **[Spring Security](https://spring.io/projects/spring-security):** Para gestão de autenticação e autorização.
* **[Auth0 Java-JWT](https://github.com/auth0/java-jwt):** Biblioteca para geração e validação de tokens JWT.
* **[Spring Data JPA](https://spring.io/projects/spring-data-jpa):** Persistência de dados.
* **[MySQL](https://www.mysql.com/):** Base de dados relacional.
* **[Flyway](https://flywaydb.org/):** Migrações de base de dados (Versionamento do esquema).
* **[Lombok](https://projectlombok.org/):** Redução de código boilerplate.
* **[SpringDoc OpenAPI (Swagger)](https://springdoc.org/):** Documentação automática da API.
* **[JUnit 5 & Mockito](https://junit.org/junit5/):** Testes unitários e de integração.

## 🔌 API Endpoints e Documentação

A API possui documentação completa via **Swagger UI**. Após executar o projeto, acesse a:

👉 **`http://localhost:8080/swagger-ui.html`**

Resumo dos principais endpoints:

| Método   | Rota            | Descrição                                              |
|:---------|:----------------|:-------------------------------------------------------|
| `POST`   | `/login`        | Autentica um utilizador e retorna o Token JWT.         |
| `POST`   | `/consultas`    | Agenda uma nova consulta (Requer JSON com ids e data). |
| `DELETE` | `/consultas`    | Cancela uma consulta (Requer JSON com id e motivo).    |
| `POST`   | `/medicos`      | Cadastra um novo médico.                               |
| `GET`    | `/medicos`      | Lista médicos ativos (paginado).                       |
| `PUT`    | `/medicos`      | Atualiza dados de um médico.                           |
| `DELETE` | `/medicos/{id}` | Inativa um médico.                                     |
| `POST`   | `/pacientes`    | Cadastra um novo paciente.                             |
| `GET`    | `/pacientes`    | Lista pacientes ativos (paginado).                     |

## ⚙️ Como Executar o Projeto

### Pré-requisitos

* Java 21 instalado.
* MySQL instalado e a correr.
* Configurar as Variáveis de Ambiente (opcional, mas recomendado para produção).

### Passo a Passo

1. **Clone o repositório:**
   ```sh
   git clone [https://github.com/Joaorooliveira/clinica-medica-api.git]
   cd clinica-medica-api
   ```

2. **Configuração da Base de Dados:**
   O ficheiro `src/main/resources/application.properties` espera as seguintes variáveis ou configurações padrão:
    * Crie uma base de dados no MySQL chamada `vollmed_api`.
    * Verifique se o utilizador é `root` e a senha está configurada (ou ajuste no arquivo).
    * *Dica:* Pode definir a variável de ambiente `JWT_SECRET` para maior segurança do token.

3. **Execute a Aplicação:**
   ```sh
   ./mvnw spring-boot:run
   ```
   *O Flyway irá criar automaticamente as tabelas `medicos`, `pacientes`, `usuarios` e `consultas`.*

4. **Teste a API:**
    * A API estará disponível em `http://localhost:8080`.
    * Utilize o Insomnia/Postman ou o próprio **Swagger UI** para testar as requisições.
    * **Nota:** Para testar os endpoints protegidos, crie primeiro um registo na tabela `usuarios` (com a senha em hash
      BCrypt) ou desabilite a segurança temporariamente para testes.

## 🧪 Testes

Para executar os testes automatizados (unitários e de integração):

```sh
./mvnw test
```

📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
