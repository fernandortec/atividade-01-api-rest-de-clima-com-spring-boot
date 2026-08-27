package api_clima.atividade_01.PrjClimaAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    @Value("${tomorrowio.api.token}")
    private String token;

    @Value("${tomorrowio.api.url}")
    private String apiUrl;

    @Value("${tomorrowio.api.city}")
    private String location;

    @Value("${tomorrowio.api.timesteps}")
    private String timesteps;

    public String preverTempo() {

        String location = "?location=curitiba";
        String urlFinal = apiUrl + location + "&timesteps=" + timesteps + "&apikey=" + token;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlFinal, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return "Falha ao obter dados meteorológicos. Código: " + responseEntity.getStatusCode();
        }
    }
}