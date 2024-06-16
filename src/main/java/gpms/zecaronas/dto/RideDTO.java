package gpms.zecaronas.dto;

import lombok.Data;

@Data
public class RideDTO {
    private String origem;
    private String destino;
    private String inicioCarona;
    private String fimCarona;
    private int quantidadePassageiros;
}