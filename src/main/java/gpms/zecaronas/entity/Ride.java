package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity @Table(name = "Caronas")
public class Ride {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                        //chave primaria

    @Getter @Setter
    private Long idPassageiro;                     //chave estrangeira

    @Getter @Setter
    private Long idMotorista;                      //chave estrangeira

    @Getter @Setter
    private String trajeto;

    @Getter @Setter
    private Date inicioCarona;

    @Getter @Setter
    private Date fimCarona;

    @Getter @Setter
    private int quantidadePassageiros;     // conta o motorista?

    @Getter @Setter
    private String status;                  //agendada; em andamento; finalizada; cancelada

}
