package discove.contentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import discove.contentservice.dto.InvestDataDto;
import discove.contentservice.service.InvestService;

@RestController
@RequestMapping("/api/invest-tunisie")
public class InvestController {

    private final InvestService investService;

    public InvestController(InvestService investService) {
        this.investService = investService;
    }

    @GetMapping
    public InvestDataDto getInvestData() {
        return investService.getInvestData();
    }
}