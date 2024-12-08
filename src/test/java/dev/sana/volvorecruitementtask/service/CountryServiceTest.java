package dev.sana.volvorecruitementtask.service;

import dev.sana.volvorecruitementtask.entity.Country;
import dev.sana.volvorecruitementtask.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CountryServiceTest {
    @Mock
    private CountryRepository countryRepository;

    @Mock
    private DataService dataService;

    @Mock
    private RestCountriesService restCountriesService;

    @InjectMocks
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchCountryData_CountryExists() {
        String cca3 = "USA";
        Country existingCountry = new Country();
        existingCountry.setCca3(cca3);

        when(countryRepository.findByCca3(cca3)).thenReturn(Optional.of(existingCountry));

        Country result = countryService.fetchCountryData(cca3);

        assertEquals(existingCountry, result);
        verifyNoInteractions(restCountriesService);
        verifyNoInteractions(dataService);
    }

    @Test
    void testFetchCountryData_CountryDoesNotExist() {
        String cca3 = "USA";
        Country newCountry = new Country();
        newCountry.setCca3(cca3);

        when(countryRepository.findByCca3(cca3)).thenReturn(Optional.empty());
        when(restCountriesService.getCountryFromRestApi(cca3)).thenReturn(newCountry);

        Country result = countryService.fetchCountryData(cca3);

        assertEquals(newCountry, result);
        verify(dataService, times(1)).saveData(newCountry);
    }
}