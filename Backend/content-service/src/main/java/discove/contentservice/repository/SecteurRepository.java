package discove.contentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import discove.contentservice.model.Secteur;
import java.util.Optional;

public interface SecteurRepository extends JpaRepository<Secteur, Long> {
    Optional<Secteur> findByNomIgnoreCase(String nom);
}