package med.voll.clinica_medica_api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Voll.med API")
                        .description(descricaoDaApi())
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@voll.med"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://voll.med/api/licenca")));
    }

    private String descricaoDaApi() {
        return """
                API Rest da aplicação **Voll.med**, desenvolvida para o gerenciamento de clínicas e consultórios médicos.
                
                Esta documentação fornece acesso a todos os recursos públicos e protegidos da aplicação, permitindo a gestão completa de dados médicos e administrativos.
                
                ### 🚀 Funcionalidades Principais
                * **Gestão de Médicos:** Cadastro, atualização de dados, listagem paginada e exclusão lógica.
                * **Gestão de Pacientes:** Controle completo de cadastro e atualização de informações de pacientes.
                * **Agendamento de Consultas:** Marcação de consultas com validação automática de horários e disponibilidade.
                * **Cancelamento de Consultas:** Processo de cancelamento seguro, exigindo o motivo da desistência.
                
                ### 🔒 Autenticação e Segurança
                A maioria dos endpoints é protegida e requer um **Token JWT** válido.
                1.  Crie um usuário ou faça login no endpoint `/login`.
                2.  Copie o token retornado no corpo da resposta.
                3.  Clique no botão **Authorize** (cadeado) no topo da página e cole o token.
                """;
    }
}