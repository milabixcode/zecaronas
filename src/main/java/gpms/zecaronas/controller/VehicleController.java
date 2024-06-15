package gpms.zecaronas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gpms.zecaronas.CurrentUser;
import gpms.zecaronas.dto.VehicleDto;
import gpms.zecaronas.entity.UserVehicle;
import gpms.zecaronas.entity.Vehicle;
import gpms.zecaronas.repository.UserVehicleRepository;
import gpms.zecaronas.repository.VehicleRepository;

@Controller()
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private UserVehicleRepository userVehicleRepo;

    @PostMapping("")
    @Transactional()
    public String criar(Model model, VehicleDto dto) {
        var vehicle = new Vehicle();
        vehicle.setPlaca(dto.getPlaca());
        vehicle.setModelo(dto.getModelo());
        vehicle.setCapacidade(dto.getCapacidade());
        vehicle.setCor(dto.getCor());

        vehicle = vehicleRepo.save(vehicle);
        var user = currentUser.get();

        var userVehicle = new UserVehicle();
        userVehicle.setUser(user);
        userVehicle.setVeiculo(vehicle);

        userVehicleRepo.save(userVehicle);

        return "redirect:/";
    }
}
