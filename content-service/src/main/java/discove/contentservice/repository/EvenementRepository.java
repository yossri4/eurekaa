package discove.contentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import discove.contentservice.model.Evenement;
import java.time.LocalDate;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    @Query("SELECT e FROM Evenement e WHERE " +
            "(:date IS NULL OR e.date = :date) AND " +
            "(:type IS NULL OR e.type = :type) " +
            "ORDER BY e.date ASC")
    List<Evenement> findWithFilters(LocalDate date, String type);
}