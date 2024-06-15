package gpms.zecaronas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import gpms.zecaronas.entity.User;
import gpms.zecaronas.repository.UserRepository;

@Service
public class CurrentUser {
    @Autowired
    private UserRepository userRepo;

    public User get() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByEmail(authentication.getName());
    }
}