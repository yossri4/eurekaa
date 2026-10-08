package discove.contentservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import discove.contentservice.dto.*;
import discove.contentservice.model.Actualite;
import discove.contentservice.repository.ActualiteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActualiteService {

    private final ActualiteRepository actualiteRepository;

    public ActualiteService(ActualiteRepository actualiteRepository) {
        this.actualiteRepository = actualiteRepository;
    }

    public ActualitesPageDto getActualites(int page, String secteur, String region, String keyword) {
        Page<Actualite> result = actualiteRepository.findWithFilters(
                secteur, region, keyword, PageRequest.of(page - 1, 10)
        );

        List<ActualiteDto> items = result.getContent().stream()
                .map(a -> new ActualiteDto(a.getId(), a.getTitre(), a.getImage(), a.getDate(),
                        a.getSecteur(), a.getRegion(), a.getResume(), null))
                .collect(Collectors.toList());

        return new ActualitesPageDto(items, result.getTotalPages(), result.getTotalElements(), page);
    }

    public ActualiteDetailDto getActualiteDetail(Long id) {
        Actualite a = actualiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actualité introuvable: " + id));

        ActualiteDto dto = new ActualiteDto(a.getId(), a.getTitre(), a.getImage(), a.getDate(),
                a.getSecteur(), a.getRegion(), a.getResume(), a.getContenu());

        List<ActualiteDto> similaires = actualiteRepository
                .findTop3BySecteurAndIdNot(a.getSecteur(), a.getId()).stream()
                .map(s -> new ActualiteDto(s.getId(), s.getTitre(), s.getImage(), s.getDate(),
                        s.getSecteur(), s.getRegion(), s.getResume(), null))
                .collect(Collectors.toList());

        return new ActualiteDetailDto(dto, similaires);
    }

    public List<ActualiteDto> getDernieresActualites() {
        return actualiteRepository.findTop3ByOrderByDateDesc().stream()
                .map(a -> new ActualiteDto(a.getId(), a.getTitre(), a.getImage(), a.getDate(),
                        a.getSecteur(), a.getRegion(), a.getResume(), null))
                .collect(Collectors.toList());
    }
}