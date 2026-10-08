package discover.authservice1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String motDePasse; // stocké hashé (BCrypt)

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private AccountStatus statut = AccountStatus.ACTIVE;

    // Champs spécifiques selon le rôle (nullable selon le cas)
    private String paysResidence;

    @ElementCollection
    private java.util.List<String> secteursInteret;

    private String specialite;
    private String pays;
    private String nomEntreprise;
    private String secteurPrincipal;
    private String region;
    private String nomSociete;
    private String paysOrigine;
    private String secteur;

    public enum Role {
        INVESTOR, PARTNER, LOCAL_PARTNER, INTERNATIONAL_COMPANY, ADMIN
    }

    public enum AccountStatus {
        ACTIVE, PENDING, SUSPENDED
    }
}