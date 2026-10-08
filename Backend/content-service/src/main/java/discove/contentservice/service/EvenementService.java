package discove.contentservice.service;

import org.springframework.stereotype.Service;
import discove.contentservice.dto.EvenementDetailDto;
import discove.contentservice.dto.EvenementDto;
import discove.contentservice.model.Evenement;
import discove.contentservice.model.Inscription;
import discove.contentservice.repository.EvenementRepository;
import discove.contentservice.repository.InscriptionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;
    private final InscriptionRepository inscriptionRepository;

    public EvenementService(EvenementRepository evenementRepository, InscriptionRepository inscriptionRepository) {
        this.evenementRepository = evenementRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    public List<EvenementDto> getEvenements(LocalDate date, String type) {
        return evenementRepository.findWithFilters(date, type).stream()
                .map(e -> new EvenementDto(e.getId(), e.getTitre(), e.getType(), e.getDate(),
                        e.getHeure(), e.getLieu(), e.getImage()))
                .collect(Collectors.toList());
    }

    public EvenementDetailDto getEvenementDetail(Long id) {
        Evenement e = evenementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement introuvable: " + id));

        return new EvenementDetailDto(e.getId(), e.getTitre(), e.getType(), e.getDate(),
                e.getHeure(), e.getLieu(), e.getImage(), e.getDescription(),
                e.getAgenda(), e.getConferenciers());
    }

    public void inscrire(Long evenementId, String userEmail) {
        if (inscriptionRepository.findByEvenementIdAndUserEmail(evenementId, userEmail).isPresent()) {
            throw new IllegalStateException("DEJA_INSCRIT");
        }

        Inscription inscription = new Inscription();
        inscription.setEvenementId(evenementId);
        inscription.setUserEmail(userEmail);
        inscriptionRepository.save(inscription);
    }
}