package discover.authservice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import discover.authservice1.model.PasswordResetToken;
import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    void deleteByUserEmail(String userEmail);
}