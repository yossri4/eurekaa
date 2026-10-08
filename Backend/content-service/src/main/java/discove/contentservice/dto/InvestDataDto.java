package discove.contentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class InvestDataDto {
    private List<AvantageDto> avantagesCompetitifs;
    private List<ZoneFrancheDto> zonesFranches;
    private List<IncitationFiscaleDto> incitationsFiscales;
    private List<EtapeDto> etapesCreation;
    private List<FaqDto> faq;

    @Data
    @AllArgsConstructor
    public static class AvantageDto {
        private String icone;
        private String titre;
        private String description;
    }

    @Data
    @AllArgsConstructor
    public static class ZoneFrancheDto {
        private String nom;
        private String image;
        private String description;
    }

    @Data
    @AllArgsConstructor
    public static class IncitationFiscaleDto {
        private String secteur;
        private String tva;
        private String impotBenefices;
        private String autres;
    }

    @Data
    @AllArgsConstructor
    public static class EtapeDto {
        private String titre;
        private String description;
    }

    @Data
    @AllArgsConstructor
    public static class FaqDto {
        private String question;
        private String reponse;
    }
}