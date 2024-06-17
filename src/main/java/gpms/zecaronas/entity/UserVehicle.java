package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//ENTIDADE CRIADA PARA TABELA ASSOCIAÇÃO
//RELAÇÃO MUITOS PRA MUITOS [User - Veiculo]

@Entity @Table(name = "users_veiculos")
public class UserVehicle {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //chave primaria

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "userId")
    private User user;           //chave estrangeira [User id]

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "vehicleId")
    private Vehicle veiculo;        //chave estrangeira [Veiculo id]

}
