package med.voll.clinica_medica_api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.clinica_medica_api.endereco.DadosEndereco;

public record DadosCadastroMedico(


        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp ="\\d{4,6}") //define o tamanho ou seja de 4 a 6 digitos apenas
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
