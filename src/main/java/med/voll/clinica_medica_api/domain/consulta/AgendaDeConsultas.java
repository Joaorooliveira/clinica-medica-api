package med.voll.clinica_medica_api.domain.consulta;

import med.voll.clinica_medica_api.domain.ValidacaoException;
import med.voll.clinica_medica_api.domain.consulta.validacoes.ValidadorAgendamentoDeConsultas;
import med.voll.clinica_medica_api.domain.medico.Medico;
import med.voll.clinica_medica_api.domain.medico.MedicoRepository;
import med.voll.clinica_medica_api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {


    private final MedicoRepository medicoRepository;
    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsultas> validadores;

    public AgendaDeConsultas(MedicoRepository medicoRepository, ConsultaRepository consultaRepository, PacienteRepository pacienteRepository) {
        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado nao existe!");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico informado nao existe!");
        }
        validadores.forEach(validador -> validador.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);

        if (medico == null) {
            throw new ValidacaoException("Nao existe medico disponivel nessa data!");
        }
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatoria quanto medico não for escolhido!");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());

    }
}
