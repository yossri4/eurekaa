package discove.contentservice.controller;

import org.springframework.web.bind.annotation.*;
import discove.contentservice.dto.SecteurDetailDto;
import discove.contentservice.model.Secteur;
import discove.contentservice.service.SecteurService;

import java.util.List;

@RestController
@RequestMapping("/api/secteurs")
public class SecteurController {

    private final SecteurService secteurService;

    public SecteurController(SecteurService secteurService) {
        this.secteurService = secteurService;
    }

    @GetMapping
    public List<Secteur> getAll() {
        return secteurService.getAllSecteurs();
    }

    @GetMapping("/{nom}")
    public SecteurDetailDto getDetail(@PathVariable String nom) {
        return secteurService.getSecteurDetail(nom);
    }
}