package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ActualiteDto {
    private Long id;
    private String titre;
    private String image;
    private LocalDate date;
    private String secteur;
    private String region;
    private String resume;
    private String contenu; // null dans la liste, rempli dans le détail
}