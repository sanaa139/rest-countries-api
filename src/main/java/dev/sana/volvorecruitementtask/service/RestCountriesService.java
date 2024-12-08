package dev.sana.volvorecruitementtask.service;

import dev.sana.volvorecruitementtask.DTO.CountryDTO;
import dev.sana.volvorecruitementtask.entity.Country;
import dev.sana.volvorecruitementtask.exceptions.CountryNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@Service
public class RestCountriesService {
    private static final String RESTCOUNTRIES_URL = "https://restcountries.com/v3/alpha";


    public Country getCountryFromRestApi(String cca3){
        WebClient webClient = WebClient.create(RESTCOUNTRIES_URL);

        Mono<CountryDTO> countryMono = webClient.get()
                .uri(RESTCOUNTRIES_URL + '/' + cca3)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(Map.class)
                                .flatMap(errorBody -> Mono.error(new CountryNotFoundException("Country with ISO 3166-1 alpha-3 code " + cca3 + " not found")))
                )
                .bodyToFlux(CountryDTO.class)
                .next();


        return countryMono
                .blockOptional(Duration.ofSeconds(5))
                .map(Country::new)
                .orElseThrow(
                        ()-> new CountryNotFoundException("Country with ISO 3166-1 alpha-3 code " + cca3 + " not found"));

    }
}
