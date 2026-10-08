package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class HomeDataDto {
    private MetricsDto metrics;
    private List<OpportuniteDto> dernieresOpportunites;
    private List<ActualiteDto> dernieresActualites;

    @Data
    @AllArgsConstructor
    public static class MetricsDto {
        private long investisseursInscrits;
        private long opportunitesDisponibles;
        private long secteursCouverts;
    }
}