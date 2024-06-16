package gpms.zecaronas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gpms.zecaronas.CurrentUser;
import gpms.zecaronas.dto.Register;
import gpms.zecaronas.dto.UserUpdate;
import gpms.zecaronas.entity.User;
import gpms.zecaronas.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    @Autowired
    private CurrentUser currentUser;

    @GetMapping("register")
    public String registerForm() {
        return "users/register";
    }

    @GetMapping("profile")
    public String profile(Model model) {
        model.addAttribute("user", currentUser.get());
        return "users/profile";
    }

    @GetMapping("edit")
    public String edit(Model model) {
        model.addAttribute("user", currentUser.get());
        return "users/edit";
    }

    @PostMapping("edit")
    public String editPut(Model model, UserUpdate dto) {
        var user = currentUser.get();

        user.setCNH(dto.getCnh());
        user.setCpf(dto.getCpf());
        user.setEmail(dto.getEmail());
        user.setTelefone(dto.getTelefone());
        user.setNome(dto.getNome());

        user = userRepo.save(user);


        model.addAttribute("user", user);
        model.addAttribute("msg", "Dados salvos com sucesso!");

        return "users/edit";
    }

    @PostMapping("register")
    public String register(HttpServletRequest request, Model model, Register dto) {
        model.addAttribute("nome", dto.nome);
        model.addAttribute("email", dto.email);

        if (!dto.senha.equals(dto.confirmacao_senha)) {
            model.addAttribute("erro", "senha e confirmação não batem");
            return "users/register";
        }

        if (userRepo.findByEmail(dto.email) != null) {
            model.addAttribute("erro", "email já está sendo usado");
            return "users/register";
        }

        var user = new User();
        user.setNome(dto.nome);
        user.setEmail(dto.email);
        user.setSenha(passEncoder.encode(dto.senha));
        user.setCNH(dto.cnh);

        userRepo.save(user);

        return "redirect:/login";
    }
}
