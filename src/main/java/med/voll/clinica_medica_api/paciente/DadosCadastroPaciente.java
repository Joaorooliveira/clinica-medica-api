package med.voll.clinica_medica_api.paciente;

import med.voll.clinica_medica_api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}
