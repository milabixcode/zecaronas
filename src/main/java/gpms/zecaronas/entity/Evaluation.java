package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "Avaliacao")
public class Evaluation {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //chave primaria

    @Getter @Setter
    private Long idCarona;         //chave estrangeira

    @Getter @Setter
    private Long idPassageiro;     //chave estrangeira

    @Getter @Setter
    private Long idMotorista;      //chave estrangeira

    @Getter @Setter
    private String comentario;

    @Getter @Setter
    private int pontuacao;          //de 0 a 5
}
