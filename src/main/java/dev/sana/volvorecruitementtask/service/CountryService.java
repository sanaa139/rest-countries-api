package dev.sana.volvorecruitementtask.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sana.volvorecruitementtask.DTO.CountryDTO;
import dev.sana.volvorecruitementtask.entity.*;
import dev.sana.volvorecruitementtask.entity.bridgetables.*;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.*;
import dev.sana.volvorecruitementtask.repository.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class CountryService {
    private final BorderRepository borderRepository;
    private final CapitalRepository capitalRepository;
    private final CountryRepository countryRepository;
    private final CurrencyRepository currencyRepository;
    private final LanguageRepository languageRepository;
    private final TimeZoneRepository timeZoneRepository;
    private final CountryCurrenciesRepository countryCurrenciesRepository;
    private final CountryCapitalsRepository countryCapitalsRepository;
    private final CountryLanguagesRepository countryLanguagesRepository;
    private final CountryBordersRepository countryBordersRepository;
    private final CountryTimeZonesRepository countryTimeZonesRepository;

    public CountryService(BorderRepository borderRepository,
                          CapitalRepository capitalRepository,
                          CountryRepository countryRepository,
                          CurrencyRepository currencyRepository,
                          LanguageRepository languageRepository,
                          TimeZoneRepository timeZoneRepository,
                          CountryCurrenciesRepository countryCurrenciesRepository,
                          CountryCapitalsRepository countryCapitalsRepository,
                          CountryLanguagesRepository countryLanguagesRepository,
                          CountryBordersRepository countryBordersRepository,
                          CountryTimeZonesRepository countryTimeZonesRepository) {
        this.borderRepository = borderRepository;
        this.capitalRepository = capitalRepository;
        this.countryRepository = countryRepository;
        this.currencyRepository = currencyRepository;
        this.languageRepository = languageRepository;
        this.timeZoneRepository = timeZoneRepository;
        this.countryCurrenciesRepository = countryCurrenciesRepository;
        this.countryCapitalsRepository = countryCapitalsRepository;
        this.countryLanguagesRepository = countryLanguagesRepository;
        this.countryBordersRepository = countryBordersRepository;
        this.countryTimeZonesRepository = countryTimeZonesRepository;

        if(countryRepository.findAll().isEmpty()){
            try{
                loadData();
            }catch(IOException e){
                System.out.println("Error occurred while loading data");
            }

        }
    }

    private void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File file = new ClassPathResource("countries.json").getFile();

        List<CountryDTO> countries = objectMapper.readValue(
                file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, CountryDTO.class)
        );
        countries.forEach(System.out::println);

        for(CountryDTO countryDTO : countries) {
            loadTables(countryDTO);
            loadBridgeTables(countryDTO);
        }
    }

    private void loadTables(CountryDTO countryDTO){
        if (countryDTO.getCurrencies() != null) {
            for (String currencyCode : countryDTO.getCurrencies().keySet()) {
                if (currencyRepository.findByCode(currencyCode).isEmpty()) {
                    currencyRepository.save(new Currency(null, currencyCode, countryDTO.getCurrencies().get(currencyCode).getName(), countryDTO.getCurrencies().get(currencyCode).getSymbol()));
                }
            }
        }

        if (countryDTO.getCapital() != null) {
            for (String capitalName : countryDTO.getCapital()) {
                if (capitalRepository.findByName(capitalName).isEmpty()) {
                    capitalRepository.save(new Capital(null, capitalName));
                }
            }
        }

        if (countryDTO.getLanguages() != null) {
            for (String languageCode : countryDTO.getLanguages().keySet()) {
                if (languageRepository.findByCode(languageCode).isEmpty()) {
                    languageRepository.save(new Language(null, languageCode, countryDTO.getLanguages().get(languageCode)));
                }
            }
        }

        if (countryDTO.getBorders() != null) {
            for (String borderName : countryDTO.getBorders()) {
                if (borderRepository.findByName(borderName).isEmpty()) {
                    borderRepository.save(new Border(null, borderName));
                }
            }
        }

        for (String timeZone : countryDTO.getTimezones()) {
            if (timeZoneRepository.findByName(timeZone).isEmpty()) {
                timeZoneRepository.save(new TimeZone(null, timeZone));
            }
        }

        if (countryRepository.findByAllData(countryDTO.getName().getCommon(), countryDTO.getName().getOfficial(), countryDTO.getRegion(), countryDTO.getSubregion(), countryDTO.getPopulation()).isEmpty()){
            countryRepository.save(new Country(null, countryDTO.getName().getCommon(), countryDTO.getName().getOfficial(), countryDTO.getRegion(), countryDTO.getSubregion(), countryDTO.getPopulation()));
        }

    }

    private void loadBridgeTables(CountryDTO countryDTO){
        Optional<Country> country = countryRepository.findByAllData(countryDTO.getName().getCommon(), countryDTO.getName().getOfficial(), countryDTO.getRegion(), countryDTO.getSubregion(), countryDTO.getPopulation());

        if (countryDTO.getCurrencies() != null) {
            for (String currencyCode : countryDTO.getCurrencies().keySet()) {
                Optional<Currency> currency = currencyRepository.findByCode(currencyCode);
                if(country.isPresent() && currency.isPresent()){
                    if (countryCurrenciesRepository.findByCountryIdAndCurrencyId(country.get().getId(), currency.get().getId()).isEmpty()) {
                        countryCurrenciesRepository.save(new CountryCurrencies(new CountryCurrenciesId(country.get().getId(), currency.get().getId())));
                    }
                }
            }
        }

        if (countryDTO.getCapital() != null) {
            for (String capitalName : countryDTO.getCapital()) {
                Optional<Capital> capital = capitalRepository.findByName(capitalName);
                if(country.isPresent() && capital.isPresent()){
                    if (countryCapitalsRepository.findByCountryIdAndCapitalId(country.get().getId(), capital.get().getId()).isEmpty()) {
                        countryCapitalsRepository.save(new CountryCapitals(new CountryCapitalsId(country.get().getId(), capital.get().getId())));
                    }
                }
            }
        }

        if (countryDTO.getLanguages() != null) {
            for (String languageCode : countryDTO.getLanguages().keySet()) {
                Optional<Language> language = languageRepository.findByCode(languageCode);
                if(country.isPresent() && language.isPresent()){
                    if (countryLanguagesRepository.findByCountryIdAndLanguageId(country.get().getId(), language.get().getId()).isEmpty()) {
                        countryLanguagesRepository.save(new CountryLanguages(new CountryLanguagesId(country.get().getId(), language.get().getId())));
                    }
                }
            }
        }

        if (countryDTO.getBorders() != null) {
            for (String borderName : countryDTO.getBorders()) {
                Optional<Border> border = borderRepository.findByName(borderName);
                if(country.isPresent() && border.isPresent()){
                    if (countryBordersRepository.findByCountryIdAndBorderId(country.get().getId(), border.get().getId()).isEmpty()) {
                        countryBordersRepository.save(new CountryBorders(new CountryBordersId(country.get().getId(), border.get().getId())));
                    }
                }
            }
        }

        if (countryDTO.getTimezones() != null) {
            for (String timeZoneName: countryDTO.getTimezones()) {
                Optional<TimeZone> timeZone = timeZoneRepository.findByName(timeZoneName);
                if(country.isPresent() && timeZone.isPresent()){
                    if (countryTimeZonesRepository.findByCountryIdAndTimeZoneId(country.get().getId(), timeZone.get().getId()).isEmpty()) {
                        countryTimeZonesRepository.save(new CountryTimeZones(new CountryTimeZonesId(country.get().getId(), timeZone.get().getId())));
                    }
                }
            }
        }
    }
}
