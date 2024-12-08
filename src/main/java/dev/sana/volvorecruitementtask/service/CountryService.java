package dev.sana.volvorecruitementtask.service;

import dev.sana.volvorecruitementtask.entity.*;
import dev.sana.volvorecruitementtask.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final DataService dataService;
    private final RestCountriesService restCountriesService;

    public CountryService(CountryRepository countryRepository, DataService dataService, RestCountriesService restCountriesService) {
        this.countryRepository = countryRepository;
        this.dataService = dataService;
        this.restCountriesService = restCountriesService;
    }

    public Country fetchCountryData(String cca3) {
        return countryRepository
                .findByCca3(cca3)
                .orElseGet(
                () -> {
                    Country newCountry = restCountriesService.getCountryFromRestApi(cca3);
                    dataService.saveData(newCountry);
                    return newCountry;
                }

        );
    }
}
