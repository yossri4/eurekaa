package discove.contentservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import discove.contentservice.model.Actualite;
import java.util.List;

public interface ActualiteRepository extends JpaRepository<Actualite, Long> {

    @Query("SELECT a FROM Actualite a WHERE " +
            "(:secteur IS NULL OR a.secteur = :secteur) AND " +
            "(:region IS NULL OR a.region = :region) AND " +
            "(:keyword IS NULL OR LOWER(a.titre) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<Actualite> findWithFilters(String secteur, String region, String keyword, Pageable pageable);

    List<Actualite> findTop3ByOrderByDateDesc();

    List<Actualite> findTop3BySecteurAndIdNot(String secteur, Long id);
}