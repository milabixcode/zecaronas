package com.trabgpms.appcarona.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity @Table(name = "Caronas")
public class Carona {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carona;                        //chave primaria

    @Getter @Setter
    private Long id_passageiro;                     //chave estrangeira

    @Getter @Setter
    private Long id_motorista;                      //chave estrangeira

    @Getter @Setter
    private String trajeto;

    @Getter @Setter
    private Date inicio_carona;

    @Getter @Setter
    private Date fim_carona;

    @Getter @Setter
    private int quantidade_passageiros;     // conta o motorista?

    @Getter @Setter
    private String status;                  //agendada; em andamento; finalizada; cancelada

}
