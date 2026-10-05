package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class EvenementDetailDto {
    private Long id;
    private String titre;
    private String type;
    private LocalDate date;
    private String heure;
    private String lieu;
    private String image;
    private String description;
    private List<String> agenda;
    private List<String> conferenciers;
}