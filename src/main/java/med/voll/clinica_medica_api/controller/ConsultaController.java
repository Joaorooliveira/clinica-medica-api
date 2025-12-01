package med.voll.clinica_medica_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.clinica_medica_api.domain.consulta.AgendaDeConsultas;
import med.voll.clinica_medica_api.domain.consulta.CancelamentoDeConsultas;
import med.voll.clinica_medica_api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.clinica_medica_api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    private final AgendaDeConsultas agenda;
    private final CancelamentoDeConsultas cancelamento;

    public ConsultaController(AgendaDeConsultas agenda, CancelamentoDeConsultas cancelamento) {
        this.agenda = agenda;
        this.cancelamento = cancelamento;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Agendar Consulta", description = "Agenda Consulta e retorna status")
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping
    @Operation(summary = "Cancelar Consulta", description = "Cancela Consulta pelo Id")
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        cancelamento.CancelamentoDeConsultas(dados);
        return ResponseEntity.noContent().build();
    }


}
