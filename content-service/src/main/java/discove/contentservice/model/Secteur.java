package discove.contentservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ElementCollection
    private List<String> chiffresClesLabels;

    @ElementCollection
    private List<String> chiffresClesValeurs;

    @ElementCollection
    private List<Integer> evolutionAnnees;

    @ElementCollection
    private List<Double> evolutionValeurs;

    @ElementCollection
    private List<String> projetsPharesNoms;

    @ElementCollection
    private List<String> projetsPharesDescriptions;

    @ElementCollection
    private List<String> avantagesFiscaux;
}