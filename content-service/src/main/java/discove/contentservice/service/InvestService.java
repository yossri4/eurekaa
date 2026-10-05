package discove.contentservice.service;

import org.springframework.stereotype.Service;
import discove.contentservice.dto.InvestDataDto;

import java.util.List;

@Service
public class InvestService {

    // Contenu institutionnel statique — cohérent avec le cahier des charges,
    // à affiner plus tard si vous voulez le rendre modifiable en base de données.
    public InvestDataDto getInvestData() {
        List<InvestDataDto.AvantageDto> avantages = List.of(
                new InvestDataDto.AvantageDto("🌍", "Position stratégique", "Porte d'entrée entre l'Europe et l'Afrique"),
                new InvestDataDto.AvantageDto("👷", "Main d'œuvre qualifiée", "Ingénieurs et techniciens formés à coût compétitif"),
                new InvestDataDto.AvantageDto("💰", "Incitations fiscales", "Régimes avantageux selon les secteurs et zones"),
                new InvestDataDto.AvantageDto("🤝", "Accords de libre-échange", "Accès facilité aux marchés UE et africains")
        );

        List<InvestDataDto.ZoneFrancheDto> zones = List.of(
                new InvestDataDto.ZoneFrancheDto("Bizerte", "/assets/zones/bizerte.jpg", "Zone franche portuaire au nord, orientée logistique et industrie."),
                new InvestDataDto.ZoneFrancheDto("Enfidha", "/assets/zones/enfidha.jpg", "Hub aéroportuaire et industriel en plein développement."),
                new InvestDataDto.ZoneFrancheDto("Zarzis", "/assets/zones/zarzis.jpg", "Zone franche du sud-est, orientée export et pêche industrielle.")
        );

        List<InvestDataDto.IncitationFiscaleDto> incitations = List.of(
                new InvestDataDto.IncitationFiscaleDto("Tourisme", "Exonération 5 ans", "10%", "Réduction droits de douane"),
                new InvestDataDto.IncitationFiscaleDto("Agriculture", "Exonération 10 ans", "0%", "Subventions équipement"),
                new InvestDataDto.IncitationFiscaleDto("Technologies", "Exonération 5 ans", "10%", "Crédit R&D"),
                new InvestDataDto.IncitationFiscaleDto("Énergies", "Exonération 10 ans", "10%", "Tarifs préférentiels"),
                new InvestDataDto.IncitationFiscaleDto("Textile", "Exonération 5 ans", "15%", "Zones industrielles dédiées"),
                new InvestDataDto.IncitationFiscaleDto("Logistique", "Exonération 5 ans", "10%", "Accès zones franches")
        );

        List<InvestDataDto.EtapeDto> etapes = List.of(
                new InvestDataDto.EtapeDto("Choix de la forme juridique", "SARL, SA, ou autre selon votre projet"),
                new InvestDataDto.EtapeDto("Dépôt du capital", "Ouverture d'un compte bancaire professionnel"),
                new InvestDataDto.EtapeDto("Enregistrement au Registre National des Entreprises", "Formalité en ligne ou guichet unique"),
                new InvestDataDto.EtapeDto("Publication au Journal Officiel", "Formalité administrative obligatoire"),
                new InvestDataDto.EtapeDto("Obtention des autorisations sectorielles", "Si nécessaire selon votre secteur d'activité")
        );

        List<InvestDataDto.FaqDto> faq = List.of(
                new InvestDataDto.FaqDto("Un étranger peut-il créer une entreprise en Tunisie ?",
                        "Oui, la loi tunisienne permet aux investisseurs étrangers de créer une entreprise, avec des formalités spécifiques selon le secteur."),
                new InvestDataDto.FaqDto("Quels sont les délais moyens de création ?",
                        "En général entre 1 et 3 semaines selon la forme juridique et le secteur d'activité."),
                new InvestDataDto.FaqDto("Existe-t-il un accompagnement pour les investisseurs ?",
                        "Oui, plusieurs agences publiques et guichets uniques accompagnent les investisseurs à chaque étape.")
        );

        return new InvestDataDto(avantages, zones, incitations, etapes, faq);
    }
}