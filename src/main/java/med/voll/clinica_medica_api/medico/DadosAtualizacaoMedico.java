package med.voll.clinica_medica_api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.clinica_medica_api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}
