package gpms.zecaronas.repository;

import org.springframework.data.repository.CrudRepository;

import gpms.zecaronas.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
