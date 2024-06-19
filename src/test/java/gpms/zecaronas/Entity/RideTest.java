package gpms.zecaronas.Entity;

import gpms.zecaronas.entity.Ride;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RideTest {
	

	Ride ride;
    
    @BeforeEach
    public void inicializa(){
        ride = new Ride();
        ride.setOrigem("Barreto");
        ride.setDestino("Praia Vermelha");
        ride.setInicioCarona(LocalDate.of(2024, 6, 17));
        ride.setFimCarona(LocalDate.of(2024, 6, 17));
        ride.setQuantidadePassageiros(3);
        ride.setStatus("Ativo");
    }
	
    @Test
    public void testeUser() {
    	inicializa();
    	Assertions.assertEquals("Barreto", ride.getOrigem());
    	Assertions.assertEquals("Praia Vermelha", ride.getDestino());
    	Assertions.assertEquals(LocalDate.of(2024, 6, 17), ride.getInicioCarona());
    	Assertions.assertEquals(LocalDate.of(2024, 6, 17), ride.getFimCarona());
    	Assertions.assertEquals(3, ride.getQuantidadePassageiros());
    	Assertions.assertEquals("Ativo", ride.getStatus());
    }
    
}