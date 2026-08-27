package api_clima.atividade_01.PrjClimaAPI.controller;

import org.springframework.web.bind.annotation.RestController;
import api_clima.atividade_01.PrjClimaAPI.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {
    private final ClimaService service;

    public Controller(ClimaService service) {
        this.service = service;
    }

    
    @GetMapping("/clima")
    public String preverTempo(){
        return service.preverTempo();
    }
}
