package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ActualitesPageDto {
    private List<ActualiteDto> items;
    private int totalPages;
    private long totalItems;
    private int currentPage;
}