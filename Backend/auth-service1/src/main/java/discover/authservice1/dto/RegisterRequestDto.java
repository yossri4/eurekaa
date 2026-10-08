package discover.authservice1.dto;

import lombok.Data;
import java.util.List;

@Data
public class RegisterRequestDto {
    private String role;
    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;
    private String paysResidence;
    private List<String> secteursInteret;
    private String specialite;
    private String pays;
    private String nomEntreprise;
    private String secteurPrincipal;
    private String region;
    private String nomSociete;
    private String paysOrigine;
    private String secteur;
}
