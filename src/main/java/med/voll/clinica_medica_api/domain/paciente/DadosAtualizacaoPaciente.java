package med.voll.clinica_medica_api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.clinica_medica_api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco

) {
}
