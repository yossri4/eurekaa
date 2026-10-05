package discove.contentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import discove.contentservice.model.Opportunite;
import java.util.List;

public interface OpportuniteRepository extends JpaRepository<Opportunite, Long> {
    List<Opportunite> findTop3ByOrderByDatePublicationDesc();
}