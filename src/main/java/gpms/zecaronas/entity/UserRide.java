package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//ENTIDADE CRIADA PARA TABELA ASSOCIAÇÃO
//RELAÇÃO MUITOS PRA MUITOS [User - Caronas]

@Entity @Table(name = "Users_caronas")
public class UserRide {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_user")
    private User user;                      //chave estrangeira para id_user

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "id_carona")
    private Ride ride;                  //chave estrangeira para id_carona

}
