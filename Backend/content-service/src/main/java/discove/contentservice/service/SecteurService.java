package discove.contentservice.service;

import org.springframework.stereotype.Service;
import discove.contentservice.dto.SecteurDetailDto;
import discove.contentservice.model.Secteur;
import discove.contentservice.repository.SecteurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecteurService {

    private final SecteurRepository secteurRepository;

    public SecteurService(SecteurRepository secteurRepository) {
        this.secteurRepository = secteurRepository;
    }

    public List<Secteur> getAllSecteurs() {
        return secteurRepository.findAll();
    }

    public SecteurDetailDto getSecteurDetail(String nom) {
        Secteur s = secteurRepository.findByNomIgnoreCase(nom)
                .orElseThrow(() -> new RuntimeException("Secteur introuvable: " + nom));

        List<SecteurDetailDto.ChiffreCleDto> chiffresCles = new ArrayList<>();
        for (int i = 0; i < s.getChiffresClesLabels().size(); i++) {
            chiffresCles.add(new SecteurDetailDto.ChiffreCleDto(
                    s.getChiffresClesLabels().get(i),
                    s.getChiffresClesValeurs().get(i)
            ));
        }

        List<SecteurDetailDto.ChiffreAnnuelDto> evolution = new ArrayList<>();
        for (int i = 0; i < s.getEvolutionAnnees().size(); i++) {
            evolution.add(new SecteurDetailDto.ChiffreAnnuelDto(
                    s.getEvolutionAnnees().get(i),
                    s.getEvolutionValeurs().get(i)
            ));
        }

        List<SecteurDetailDto.ProjetPhareDto> projets = new ArrayList<>();
        for (int i = 0; i < s.getProjetsPharesNoms().size(); i++) {
            projets.add(new SecteurDetailDto.ProjetPhareDto(
                    s.getProjetsPharesNoms().get(i),
                    s.getProjetsPharesDescriptions().get(i)
            ));
        }

        return new SecteurDetailDto(
                s.getNom(),
                chiffresCles,
                evolution,
                projets,
                s.getAvantagesFiscaux()
        );
    }
}