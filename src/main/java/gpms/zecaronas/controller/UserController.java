package gpms.zecaronas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gpms.zecaronas.entity.User;
import gpms.zecaronas.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String test(Model model) {
        model.addAttribute("pizza", "deliawdawdcious");
        return "yay";
    }

    @GetMapping("/criar")
    public String create(Model model, @RequestParam String name) {
        var user = new User();
        user.setNome(name);
        user.setEmail(name + "@email.com");

        userRepo.save(user);
        
        model.addAttribute("username", user.getNome());

        return "created";
    }


}
