package med.voll.clinica_medica_api.controller;

import med.voll.clinica_medica_api.endereco.Endereco;
import med.voll.clinica_medica_api.medico.DadosCadastroMedico;
import med.voll.clinica_medica_api.medico.Medico;
import med.voll.clinica_medica_api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){ //O RequestBody pega o corpo da requisicao e guarda na String json
        repository.save(new Medico(dados));
    }
}
