package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
