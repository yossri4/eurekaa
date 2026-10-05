package discove.contentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import discove.contentservice.dto.EvenementDetailDto;
import discove.contentservice.dto.EvenementDto;
import discove.contentservice.service.EvenementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping
    public List<EvenementDto> getEvenements(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String type) {
        return evenementService.getEvenements(date, type);
    }

    @GetMapping("/{id}")
    public EvenementDetailDto getDetail(@PathVariable Long id) {
        return evenementService.getEvenementDetail(id);
    }

    @PostMapping("/{id}/inscription")
    public ResponseEntity<?> inscrire(@PathVariable Long id) {
        String userEmail = org.springframework.security.core.context.SecurityContextHolder
                .getContext().getAuthentication().getName();

        if (userEmail == null || userEmail.equals("anonymousUser")) {
            return ResponseEntity.status(401).body(Map.of("message", "Vous devez être connecté."));
        }

        try {
            evenementService.inscrire(id, userEmail);
            return ResponseEntity.ok(Map.of("message", "Inscription confirmée"));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(Map.of("message", "Vous êtes déjà inscrit à cet événement."));
        }
    }
}