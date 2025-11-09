package med.voll.clinica_medica_api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
    private String bairro;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.uf = dados.uf();
        this.cep = dados.cep();
        this.complemento = dados.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro()!=null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro()!=null) {
            this.bairro = dados.bairro();
        }
        if(dados.cidade()!=null) {
            this.cidade = dados.cidade();
        }
        if(dados.numero()!=null) {
            this.numero = dados.numero();
        }
        if(dados.uf()!=null) {
            this.uf = dados.uf();
        }
        if(dados.cep()!=null) {
            this.cep = dados.cep();
        }
        if(dados.complemento()!=null) {
            this.complemento = dados.complemento();
        }

    }
}
