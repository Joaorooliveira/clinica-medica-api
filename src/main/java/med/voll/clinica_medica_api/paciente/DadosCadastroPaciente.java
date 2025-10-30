package med.voll.clinica_medica_api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.clinica_medica_api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}") //ou seja o numero pode ser de 9 a 11 digitos
        String telefone,

        @NotBlank
        String cpf,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
