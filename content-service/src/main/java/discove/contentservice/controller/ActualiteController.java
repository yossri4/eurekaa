package discove.contentservice.controller;

import org.springframework.web.bind.annotation.*;
import discove.contentservice.dto.ActualiteDetailDto;
import discove.contentservice.dto.ActualitesPageDto;
import discove.contentservice.service.ActualiteService;

@RestController
@RequestMapping("/api/actualites")
public class ActualiteController {

    private final ActualiteService actualiteService;

    public ActualiteController(ActualiteService actualiteService) {
        this.actualiteService = actualiteService;
    }

    @GetMapping
    public ActualitesPageDto getActualites(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String secteur,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String keyword) {
        return actualiteService.getActualites(page, secteur, region, keyword);
    }

    @GetMapping("/{id}")
    public ActualiteDetailDto getDetail(@PathVariable Long id) {
        return actualiteService.getActualiteDetail(id);
    }
}