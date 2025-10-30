package med.voll.clinica_medica_api.controller;

import med.voll.clinica_medica_api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){ //O RequestBody pega o corpo da requisicao e guarda na String json
        System.out.println(dados);
    }
}
