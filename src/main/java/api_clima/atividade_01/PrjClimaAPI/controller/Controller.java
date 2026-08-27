package api_clima.atividade_01.PrjClimaAPI.controller;

import org.springframework.web.bind.annotation.RestController;
import api_clima.atividade_01.PrjClimaAPI.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Controller {
    private final ClimaService service;

    public Controller(ClimaService service) {
        this.service = service;
    }

    
    @GetMapping("/clima")
    public String preverTempoBh(){
        return service.preverTempo("belohorizonte");
    }

    
    @GetMapping("/clima/{cidade}")
    public String preverTempo(@PathVariable String cidade){
        return service.preverTempo(cidade);
    }
}
