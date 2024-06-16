package gpms.zecaronas.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gpms.zecaronas.CurrentUser;
import gpms.zecaronas.dto.RideApplyDTO;
import gpms.zecaronas.dto.RideDTO;
import gpms.zecaronas.entity.Ride;
import gpms.zecaronas.entity.UserRide;
import gpms.zecaronas.policy.RidePolicy;
import gpms.zecaronas.repository.RideRepository;
import gpms.zecaronas.repository.UserRideRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller()
@RequestMapping("rides")
public class RideController {
    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private RideRepository rideRepo;

    @Autowired
    private UserRideRepository userRideRepo;

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("ride", new Ride());
        model.addAttribute("user", currentUser.get());
        return "rides/create";
    }

    @PostMapping("create")
    public String createPost(Model model, RedirectAttributes redirectAttributes, RideDTO dto) {
        var ride = new Ride();
        ride.setOrigem(dto.getOrigem());
        ride.setDestino(dto.getDestino());
        ride.setInicioCarona(LocalDate.parse(dto.getInicioCarona()));
        ride.setFimCarona(LocalDate.parse(dto.getFimCarona()));
        ride.setQuantidadePassageiros(dto.getQuantidadePassageiros());

        ride.setIdMotorista(currentUser.get().getId());
        ride.setStatus("agendada");

        rideRepo.save(ride);

        redirectAttributes.addFlashAttribute("msg", "Carona criada com sucesso!");

        return "redirect:/";
    }

    @PostMapping("apply")
    public String apply(Model model, RideApplyDTO dto, RedirectAttributes redirectAttributes) {
        var ride = rideRepo.findById(Long.parseLong(dto.rideId)).get();

        var policy = new RidePolicy(currentUser.get(), ride);

        if (!policy.canApply()) {
            redirectAttributes.addFlashAttribute("msg", "Você não pode aplicar a essa corrida :(");
            return "redirect:/";
        }

        var userRide = new UserRide();
        userRide.setRide(ride);
        userRide.setUser(currentUser.get());

        userRideRepo.save(userRide);

        redirectAttributes.addFlashAttribute("msg", "Pedido feito com sucesso!");
        return "redirect:/";
    }

    @PostMapping("cancel")
    public String cancel(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        var rideId = Long.parseLong(request.getParameter("rideId"));
        var ride = rideRepo.findById(rideId).get();

        switch (ride.relationWith(currentUser.get())) {
            case "driver":
                rideRepo.delete(ride);
                break;
            case "passenger":
                var userRide = userRideRepo.findByUserAndRide(currentUser.get(), ride).get();
                userRideRepo.delete(userRide);
                break;
            default:
                return "";
        }

        redirectAttributes.addFlashAttribute("msg", "carona cancelada com sucesso!");
        return "redirect:/";
    }
}
