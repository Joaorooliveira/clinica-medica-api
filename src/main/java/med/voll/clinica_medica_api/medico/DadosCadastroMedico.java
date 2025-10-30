package med.voll.clinica_medica_api.medico;

import med.voll.clinica_medica_api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  DadosEndereco endereco) {
}
