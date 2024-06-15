package gpms.zecaronas.dto;

import lombok.Data;

@Data
public class VehicleDto {
    public int userId;
    public String placa;
    public String modelo;
    public int capacidade;
    public String cor;
}
