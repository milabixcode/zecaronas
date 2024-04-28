package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "Usuarios")
public class User {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;            //chave primaria

    @Getter @Setter
    private int cpf;            //chave candidata (pensando em usar o CPF ja como o login)

    @Setter @Getter
    private String nome;

    @Getter @Setter
    private String senha;       //ainda preciso ver autenticação e tals

    @Getter @Setter
    private int telefone;       //apenas um numero de telefone por usuário

    @Getter @Setter
    private String tipo;        //não sei se isso será o definitivo, mas só pra ter algo
                                //que separe usuario passageiro e usuario motorista
    @Getter @Setter
    private Long CNH;           //não tenho CNH entao nao sei mto bem mexer nisso lul
                                //mas acho que são 12 numeros né?

    @Getter @Setter
    private String email;

                                @OneToMany(mappedBy = "user")
    private List<User_Veiculo> userVeiculos = new ArrayList<>();

    //private List <Avaliacao> avaliacoes;

}
