package gpms.zecaronas.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gpms.zecaronas.CurrentUser;
import gpms.zecaronas.entity.Ride;
import gpms.zecaronas.repository.RideRepository;
import gpms.zecaronas.ui.RideUI;

@Controller()
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private RideRepository rideRepo;

    @GetMapping("")
    public String home(Model model) {
        var user = currentUser.get();

        Function<List<Ride>, List<RideUI>> convert = rides -> rides.stream().map(ride -> RideUI.from(ride, user)).collect(Collectors.toList());

        model.addAttribute("rides", convert.apply(rideRepo.findLastRides()));
        model.addAttribute("myRides", convert.apply(rideRepo.ridesWithUser(user.getId())));
        model.addAttribute("user", currentUser.get());
        return "home";
    }
}
