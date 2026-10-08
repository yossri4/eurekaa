package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EvenementDto {
    private Long id;
    private String titre;
    private String type;
    private LocalDate date;
    private String heure;
    private String lieu;
    private String image;
}