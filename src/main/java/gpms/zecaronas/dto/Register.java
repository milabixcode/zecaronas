package gpms.zecaronas.dto;


import lombok.Data;

@Data
public class Register {
    public String nome;
    public String email;
    public String senha;
    public String confirmacao_senha;
    public String cnh;
}
