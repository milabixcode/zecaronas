package gpms.zecaronas;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gpms.zecaronas.entity.User;
import gpms.zecaronas.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService {

    UserRepository repository;
    
    public AppUserDetailsService(UserRepository repository){
        this.repository = repository;
    }

    // Metodo usado para buscar o usuario no banco para a autenticação pelo spring security
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = Optional.ofNullable(repository.findByEmail(email))
                    .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getSenha(),
                new ArrayList<>());
    }
}