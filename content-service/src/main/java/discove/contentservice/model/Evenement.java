package discove.contentservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String type;
    private LocalDate date;
    private String heure;
    private String lieu;
    private String image;

    @Column(length = 3000)
    private String description;

    @ElementCollection
    private List<String> agenda;

    @ElementCollection
    private List<String> conferenciers;
}