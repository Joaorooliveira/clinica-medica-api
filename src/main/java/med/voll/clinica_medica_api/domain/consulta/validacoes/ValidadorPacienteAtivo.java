package med.voll.clinica_medica_api.domain.consulta.validacoes;

import med.voll.clinica_medica_api.domain.ValidacaoException;
import med.voll.clinica_medica_api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.clinica_medica_api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com paciente excluido");
        }
    }
}
