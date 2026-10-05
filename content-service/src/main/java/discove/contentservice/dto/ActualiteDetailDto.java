package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ActualiteDetailDto {
    private ActualiteDto actualite;
    private List<ActualiteDto> similaires;
}