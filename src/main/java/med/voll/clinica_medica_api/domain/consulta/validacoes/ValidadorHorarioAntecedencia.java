package med.voll.clinica_medica_api.domain.consulta.validacoes;

import med.voll.clinica_medica_api.domain.ValidacaoException;
import med.voll.clinica_medica_api.domain.consulta.DadosAgendamentoConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();

        if(diferencaEmMinutos <30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia minima de 30 minutos");
        }
    }
}
