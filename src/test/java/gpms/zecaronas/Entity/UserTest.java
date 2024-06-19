package gpms.zecaronas.Entity;

import gpms.zecaronas.entity.User;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class UserTest {
	

	User user;
    
    @BeforeEach
    public void inicializa(){
        user = new User();
        user = new User();
        user.setNome("user");
        user.setCpf("0123456789");
        user.setSenha("senha@123");
        user.setTelefone("2122332255");
        user.setTipo("Passageiro");
        user.setCNH("012030405060");
    }
    

	
    @Test
    public void testeUser() {
    	inicializa();
    	Assertions.assertEquals("user", user.getNome());
    	Assertions.assertEquals("0123456789", user.getCpf());
    	Assertions.assertEquals("senha@123", user.getSenha());
    	Assertions.assertEquals("2122332255", user.getTelefone());
    	Assertions.assertEquals("Passageiro", user.getTipo());
    	Assertions.assertEquals("012030405060", user.getCNH());
    }
}