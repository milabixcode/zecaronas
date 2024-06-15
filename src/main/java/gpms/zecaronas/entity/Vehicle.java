package gpms.zecaronas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "Veiculos")
public class Vehicle {

    @Setter @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //chave primaria

    @Setter @Getter
    private String placa;

    @Setter @Getter
    private String modelo;

    @Setter @Getter
    private int capacidade;

    @Setter @Getter
    private String cor;

    @OneToMany(mappedBy = "veiculo")
    private List<UserVehicle> userVeiculos = new ArrayList<>();
}
