package gpms.zecaronas.Entity;

import gpms.zecaronas.entity.Vehicle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class VehicleTest {
	

	Vehicle vehicle;
    
    @BeforeEach
    public void inicializa(){
        vehicle = new Vehicle();
        vehicle = new Vehicle();
        vehicle.setId(Long.valueOf(1));
        vehicle.setPlaca("AB1C234");
        vehicle.setModelo("Onix");
        vehicle.setCapacidade(4);
        vehicle.setCor("Preto");
    }

	
    @Test
    public void testeVehicle() {
    	inicializa();
    	Assertions.assertEquals(Long.valueOf(1), vehicle.getId());
    	Assertions.assertEquals("AB1C234", vehicle.getPlaca());
    	Assertions.assertEquals("Onix", vehicle.getModelo());
    	Assertions.assertEquals(4, vehicle.getCapacidade());
    	Assertions.assertEquals("Preto", vehicle.getCor());
    }
}