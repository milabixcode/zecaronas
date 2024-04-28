package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "Veiculos")
public class Veiculo {

    @Setter @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veiculo;                //chave primaria

    @Setter @Getter
    private String placa;

    @Setter @Getter
    private String modelo;

    @Setter @Getter
    private int capacidade;

    @Setter @Getter
    private String cor;

    @OneToMany(mappedBy = "veiculo")
    private List<User_Veiculo> userVeiculos = new ArrayList<>();
}
