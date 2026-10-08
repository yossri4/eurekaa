package discove.contentservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import discove.contentservice.model.Secteur;
import discove.contentservice.repository.SecteurRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final SecteurRepository secteurRepository;

    public DataSeeder(SecteurRepository secteurRepository) {
        this.secteurRepository = secteurRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        for (Secteur s : secteurRepository.findAll()) {
            if (s.getChiffresClesLabels() == null || s.getChiffresClesLabels().isEmpty()) {
                remplirSecteur(s);
                secteurRepository.save(s);
            }
        }
    }

    private void remplirSecteur(Secteur s) {
        switch (s.getNom()) {
            case "Tourisme" -> {
                s.setChiffresClesLabels(new ArrayList<>(List.of("Arrivées touristiques", "Recettes annuelles", "Emplois directs")));
                s.setChiffresClesValeurs(new ArrayList<>(List.of("9.4M", "2.1 Md TND", "400 000")));
                s.setEvolutionAnnees(new ArrayList<>(List.of(2021, 2022, 2023, 2024, 2025)));
                s.setEvolutionValeurs(new ArrayList<>(List.of(5.2, 6.8, 7.9, 8.6, 9.4)));
                s.setProjetsPharesNoms(new ArrayList<>(List.of("Rénovation littoral Hammamet", "Éco-resort Djerba")));
                s.setProjetsPharesDescriptions(new ArrayList<>(List.of(
                        "Modernisation des infrastructures hôtelières de la zone.",
                        "Complexe touristique durable axé sur l'écotourisme.")));
                s.setAvantagesFiscaux(new ArrayList<>(List.of(
                        "Exonération d'impôt sur les bénéfices pendant 5 ans",
                        "Réduction des droits de douane sur les équipements importés")));
            }
            case "Agriculture" -> {
                s.setChiffresClesLabels(new ArrayList<>(List.of("Exportations agricoles", "Surface cultivée", "Emplois du secteur")));
                s.setChiffresClesValeurs(new ArrayList<>(List.of("1.8 Md TND", "4.9M ha", "530 000")));
                s.setEvolutionAnnees(new ArrayList<>(List.of(2021, 2022, 2023, 2024, 2025)));
                s.setEvolutionValeurs(new ArrayList<>(List.of(1.2, 1.4, 1.5, 1.7, 1.8)));
                s.setProjetsPharesNoms(new ArrayList<>(List.of("Modernisation huile d'olive Sfax", "Agriculture bio Nabeul")));
                s.setProjetsPharesDescriptions(new ArrayList<>(List.of(
                        "Équipement de nouvelles unités de trituration modernes.",
                        "Développement de filières biologiques certifiées export.")));
                s.setAvantagesFiscaux(new ArrayList<>(List.of(
                        "Exonération totale pendant 10 ans",
                        "Subventions à l'acquisition de matériel agricole")));
            }
            case "Technologies" -> {
                s.setChiffresClesLabels(new ArrayList<>(List.of("Startups actives", "Exportations IT", "Emplois tech")));
                s.setChiffresClesValeurs(new ArrayList<>(List.of("850+", "1.2 Md TND", "90 000")));
                s.setEvolutionAnnees(new ArrayList<>(List.of(2021, 2022, 2023, 2024, 2025)));
                s.setEvolutionValeurs(new ArrayList<>(List.of(0.6, 0.8, 0.95, 1.1, 1.2)));
                s.setProjetsPharesNoms(new ArrayList<>(List.of("Technopark Sfax", "Hub IA Tunis")));
                s.setProjetsPharesDescriptions(new ArrayList<>(List.of(
                        "Pôle technologique dédié aux startups et sous-traitance IT.",
                        "Centre de recherche appliquée en intelligence artificielle.")));
                s.setAvantagesFiscaux(new ArrayList<>(List.of(
                        "Exonération d'impôt sur les bénéfices pendant 5 ans",
                        "Crédit d'impôt recherche et développement (R&D)")));
            }
            case "Énergies" -> {
                s.setChiffresClesLabels(new ArrayList<>(List.of("Capacité renouvelable", "Investissements", "Emplois du secteur")));
                s.setChiffresClesValeurs(new ArrayList<>(List.of("2.4 GW", "3.6 Md TND", "45 000")));
                s.setEvolutionAnnees(new ArrayList<>(List.of(2021, 2022, 2023, 2024, 2025)));
                s.setEvolutionValeurs(new ArrayList<>(List.of(1.1, 1.5, 1.9, 2.1, 2.4)));
                s.setProjetsPharesNoms(new ArrayList<>(List.of("Parc éolien Bizerte", "Centrale solaire Tozeur")));
                s.setProjetsPharesDescriptions(new ArrayList<>(List.of(
                        "Extension de la capacité éolienne du nord du pays.",
                        "Projet photovoltaïque à grande échelle dans le sud.")));
                s.setAvantagesFiscaux(new ArrayList<>(List.of(
                        "Exonération d'impôt pendant 10 ans",
                        "Tarifs de rachat préférentiels garantis")));
            }
            case "Textile" -> {
                s.setChiffresClesLabels(new ArrayList<>(List.of("Exportations textiles", "Unités de production", "Emplois du secteur")));
                s.setChiffresClesValeurs(new ArrayList<>(List.of("2.9 Md TND", "1 600+", "160 000")));
                s.setEvolutionAnnees(new ArrayList<>(List.of(2021, 2022, 2023, 2024, 2025)));
                s.setEvolutionValeurs(new ArrayList<>(List.of(2.1, 2.3, 2.6, 2.8, 2.9)));
                s.setProjetsPharesNoms(new ArrayList<>(List.of("Zone industrielle Monastir", "Cluster textile Ksar Hellal")));
                s.setProjetsPharesDescriptions(new ArrayList<>(List.of(
                        "Extension des capacités industrielles textiles régionales.",
                        "Mise en réseau des sous-traitants textiles locaux.")));
                s.setAvantagesFiscaux(new ArrayList<>(List.of(
                        "Exonération d'impôt pendant 5 ans",
                        "Accès prioritaire aux zones industrielles dédiées")));
            }
            case "Logistique" -> {
                s.setChiffresClesLabels(new ArrayList<>(List.of("Volume de fret annuel", "Ports actifs", "Emplois du secteur")));
                s.setChiffresClesValeurs(new ArrayList<>(List.of("35M tonnes", "8", "70 000")));
                s.setEvolutionAnnees(new ArrayList<>(List.of(2021, 2022, 2023, 2024, 2025)));
                s.setEvolutionValeurs(new ArrayList<>(List.of(24.5, 27.8, 30.2, 33.1, 35.0)));
                s.setProjetsPharesNoms(new ArrayList<>(List.of("Port en eau profonde Enfidha", "Corridor logistique Bizerte")));
                s.setProjetsPharesDescriptions(new ArrayList<>(List.of(
                        "Nouveau port stratégique pour le commerce international.",
                        "Développement des connexions routières et portuaires.")));
                s.setAvantagesFiscaux(new ArrayList<>(List.of(
                        "Exonération d'impôt pendant 5 ans",
                        "Accès facilité aux zones franches portuaires")));
            }
            default -> {
                // Aucun secteur inconnu prévu ; rien à faire.
            }
        }
    }
}