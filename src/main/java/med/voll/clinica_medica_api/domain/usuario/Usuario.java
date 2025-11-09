package med.voll.clinica_medica_api.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "usuarios")
@Table(name = "/Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String senha;
}
