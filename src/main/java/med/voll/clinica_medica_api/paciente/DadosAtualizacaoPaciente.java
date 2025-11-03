package med.voll.clinica_medica_api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.clinica_medica_api.endereco.DadosEndereco;
import med.voll.clinica_medica_api.endereco.Endereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco

) {
}
