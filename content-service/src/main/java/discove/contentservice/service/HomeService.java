package discove.contentservice.service;

import org.springframework.stereotype.Service;
import discove.contentservice.dto.HomeDataDto;
import discove.contentservice.dto.OpportuniteDto;
import discove.contentservice.repository.ActualiteRepository;
import discove.contentservice.repository.OpportuniteRepository;
import discove.contentservice.repository.SecteurRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    private final OpportuniteRepository opportuniteRepository;
    private final ActualiteService actualiteService;
    private final SecteurRepository secteurRepository;

    // Ces chiffres (investisseurs inscrits) viendront normalement du backend d'auth du superviseur.
    // En attendant, valeur simulée simple.
    private static final long INVESTISSEURS_INSCRITS_SIMULE = 250;

    public HomeService(OpportuniteRepository opportuniteRepository, ActualiteService actualiteService,
                       SecteurRepository secteurRepository) {
        this.opportuniteRepository = opportuniteRepository;
        this.actualiteService = actualiteService;
        this.secteurRepository = secteurRepository;
    }

    public HomeDataDto getHomeData() {
        List<OpportuniteDto> opportunites = opportuniteRepository.findTop3ByOrderByDatePublicationDesc().stream()
                .map(o -> new OpportuniteDto(o.getId(), o.getTitre(), o.getImage(), o.getSecteur(), o.getDatePublication()))
                .collect(Collectors.toList());

        HomeDataDto.MetricsDto metrics = new HomeDataDto.MetricsDto(
                INVESTISSEURS_INSCRITS_SIMULE,
                opportuniteRepository.count(),
                secteurRepository.count()
        );

        return new HomeDataDto(metrics, opportunites, actualiteService.getDernieresActualites());
    }
}