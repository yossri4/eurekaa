package discove.contentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import discove.contentservice.model.Inscription;
import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    Optional<Inscription> findByEvenementIdAndUserEmail(Long evenementId, String userEmail);
}