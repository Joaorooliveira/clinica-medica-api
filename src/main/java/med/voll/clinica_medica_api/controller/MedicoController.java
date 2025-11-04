package med.voll.clinica_medica_api.controller;

import jakarta.validation.Valid;
import med.voll.clinica_medica_api.endereco.Endereco;
import med.voll.clinica_medica_api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ //O RequestBody pega o corpo da requisicao e guarda
        //na dto dados do tipo DadosDadastroMedico
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10,sort ={"nome"}) Pageable paginacao){ //Tipo de
        // metodo com instrucoes de paginacao e esse  @PageableDefault(size = 10,sort ={"nome"} e para definir o
        // padrao sem precisar alterar a url entao se n mexer nada la na url por padrao vai ficar assim caso queira
        // definir como vc vai querer la na url ai sobrescreve essa Anotacao
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        //return repository.findAll(paginacao).map(DadosListagemMedico::new); //retorno dps com o page
        //return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList(); retorno antes
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico =repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
         var medico =repository.getReferenceById(id);
        medico.excluir();
        //repository.deleteById(id); //Deleta pelo ID(Exclui do banco de dados)
    }
}
