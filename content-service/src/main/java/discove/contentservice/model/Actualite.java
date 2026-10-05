package discove.contentservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Actualite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String image;
    private LocalDate date;
    private String secteur;
    private String region;

    @Column(length = 500)
    private String resume;

    @Column(length = 5000)
    private String contenu;
}