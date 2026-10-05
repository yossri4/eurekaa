package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class SecteurDetailDto {
    private String nom;
    private List<ChiffreCleDto> chiffresCles;
    private List<ChiffreAnnuelDto> evolution5Ans;
    private List<ProjetPhareDto> projetsPhares;
    private List<String> avantagesFiscaux;

    @Data
    @AllArgsConstructor
    public static class ChiffreCleDto {
        private String label;
        private String valeur;
    }

    @Data
    @AllArgsConstructor
    public static class ChiffreAnnuelDto {
        private int annee;
        private double valeur;
    }

    @Data
    @AllArgsConstructor
    public static class ProjetPhareDto {
        private String nom;
        private String description;
    }
}