package lobodanicolae.U5_W7_D5_SpringSecureTest.repositories;

import lobodanicolae.U5_W7_D5_SpringSecureTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}

