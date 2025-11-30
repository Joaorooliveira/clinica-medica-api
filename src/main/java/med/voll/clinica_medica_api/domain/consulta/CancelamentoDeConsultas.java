package med.voll.clinica_medica_api.domain.consulta;

import jakarta.persistence.EntityNotFoundException;
import med.voll.clinica_medica_api.domain.consulta.validacoes.ValidadorCancelamentoAntecedencia;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelamentoDeConsultas {

    private final ConsultaRepository repository;
    private final ValidadorCancelamentoAntecedencia validador;

    public CancelamentoDeConsultas(ConsultaRepository repository, ValidadorCancelamentoAntecedencia validador) {
        this.repository = repository;
        this.validador = validador;
    }

    @Transactional
    public void CancelamentoDeConsultas(DadosCancelamentoConsulta dados) {
        var consulta = repository.findById(dados.idConsulta()).orElseThrow(() -> new EntityNotFoundException(
                "ID da consulta errada, ou consulta nao existe"));
        validador.validar(dados);
        repository.deleteById(dados.idConsulta());
    }
}
