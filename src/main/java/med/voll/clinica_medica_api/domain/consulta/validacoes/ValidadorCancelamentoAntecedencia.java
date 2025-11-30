package med.voll.clinica_medica_api.domain.consulta.validacoes;

import med.voll.clinica_medica_api.domain.ValidacaoException;
import med.voll.clinica_medica_api.domain.consulta.ConsultaRepository;
import med.voll.clinica_medica_api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoAntecedencia {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta só pode ser cancelada com antecedência mínima de 24 horas.");
        }
    }

}
