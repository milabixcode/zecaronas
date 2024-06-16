package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;

@Entity @Table(name = "Usuarios")
public class User {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            //chave primaria

    @Getter @Setter
    private String cpf;            //chave candidata (pensando em usar o CPF ja como o login)

    @Setter @Getter
    private String nome;

    @Getter @Setter
    private String senha;       //ainda preciso ver autenticação e tals

    @Getter @Setter
    private String telefone;       //apenas um numero de telefone por usuário

    @Getter @Setter
    private String tipo;        //não sei se isso será o definitivo, mas só pra ter algo
                                //que separe usuario passageiro e usuario motorista
    @Getter @Setter
    private String CNH;           //não tenho CNH entao nao sei mto bem mexer nisso lul
                                //mas acho que são 12 numeros né?

    @Getter @Setter
    private String email;

    @Getter
                                @OneToMany(mappedBy = "user")
    private List<UserVehicle> vehicles = new ArrayList<>();

    public boolean isDriver() {
        return Strings.isNotBlank(this.CNH);
    }
}
