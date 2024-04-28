package com.trabgpms.appcarona.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//ENTIDADE CRIADA PARA TABELA ASSOCIAÇÃO
//RELAÇÃO MUITOS PRA MUITOS [User - Veiculo]

@Entity @Table(name = "Users_veiculos")
public class User_Veiculo {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //chave primaria

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_user")
    private User user;           //chave estrangeira [User id]

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;        //chave estrangeira [Veiculo id]

}
