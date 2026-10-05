package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OpportuniteDto {
    private Long id;
    private String titre;
    private String image;
    private String secteur;
    private LocalDate datePublication;
}