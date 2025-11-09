package med.voll.clinica_medica_api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.clinica_medica_api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}
