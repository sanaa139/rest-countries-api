package dev.sana.volvorecruitementtask.controller;

import dev.sana.volvorecruitementtask.DTO.ApiResponse;
import dev.sana.volvorecruitementtask.entity.Country;
import dev.sana.volvorecruitementtask.service.CountryService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("api/{cca3}")
    public ApiResponse<Country> getData(@PathVariable String cca3){
        if (!cca3.matches("^[A-Za-z]{3}$")) {
            throw new IllegalArgumentException("Invalid cca3 format. Must be exactly 3 letters.");
        }
        return new ApiResponse<>(
                "success",
                countryService.fetchCountryData(cca3.toUpperCase())
        );
    }
}
