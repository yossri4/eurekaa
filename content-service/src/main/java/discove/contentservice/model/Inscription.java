package discove.contentservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long evenementId;
    private String userEmail; // extrait du JWT plus tard
    private LocalDateTime dateInscription = LocalDateTime.now();
}