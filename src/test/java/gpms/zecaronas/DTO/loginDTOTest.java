package com.gpms.zeCARona.DTO;

import com.gpms.zeCARona.DTO.LoginDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JoseVitor
 */
public class LoginDTOTest {
    
    private LoginDTO user;
    
    @BeforeEach
    public void inicializa(){
        user = new LoginDTO("user@user.com", "senha123");
        user.setEmail("user@user.com");
        user.setSenha("senha123");
    }
    
    @Test
    public void testGetEmail(){
        Assertions.assertEquals("user@user.com", user.getEmail());
    }
    
    @Test
    public void testGetSenha(){
        Assertions.assertEquals("senha123", user.getSenha());
    }
    
}
