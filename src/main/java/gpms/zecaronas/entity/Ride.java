package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "Caronas")
public class Ride {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                        //chave primaria

    @Getter @Setter
    private Long idPassageiro;                     //chave estrangeira

    @Getter @Setter
    private Long idMotorista;                      //chave estrangeira

    @Getter @Setter
    private String origem;

    @Getter @Setter
    private String destino;

    @Getter @Setter
    private LocalDate inicioCarona;

    @Getter @Setter
    private LocalDate fimCarona;

    @Getter @Setter
    private int quantidadePassageiros;     // conta o motorista?

    @Getter @Setter
    private String status;                  //agendada; em andamento; finalizada; cancelada

    @Getter
    @OneToMany(mappedBy = "ride")
    private List<UserRide> users = new ArrayList<>();
}
