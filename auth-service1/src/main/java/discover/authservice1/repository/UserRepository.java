package discover.authservice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import discover.authservice1.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}