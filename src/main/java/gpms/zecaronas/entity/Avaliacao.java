package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "Avaliacao")
public class Avaliacao {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avaliacao;                //chave primaria

    @Getter @Setter
    private Long id_carona;         //chave estrangeira

    @Getter @Setter
    private Long id_passageiro;     //chave estrangeira

    @Getter @Setter
    private Long id_motorista;      //chave estrangeira

    @Getter @Setter
    private String comentario;

    @Getter @Setter
    private int pontuacao;          //de 0 a 5
}
