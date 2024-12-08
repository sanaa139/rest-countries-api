package dev.sana.volvorecruitementtask.service;

import dev.sana.volvorecruitementtask.entity.*;
import dev.sana.volvorecruitementtask.entity.bridgetables.*;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.*;
import dev.sana.volvorecruitementtask.repository.*;
import org.springframework.stereotype.Service;

@Service
public class DataService {
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

    public DataService(BorderRepository borderRepository,
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
    }

    public void saveData(Country country){
        if (countryRepository.findByCca3(country.getCca3()).isEmpty()) {
            Integer countryId =
                    countryRepository.save(
                            new Country(country.getId(), country.getNameCommon(), country.getNameOfficial(), country.getCca3(), country.getRegion(), country.getSubregion(), country.getPopulation())
                    ).getId();

            for(Currency currency: country.getCurrencies()){
                Currency savedCurrency =
                        currencyRepository.findByCode(currency.getCode())
                                .orElseGet(() ->
                                        currencyRepository.save(new Currency(null, currency.getCode(), currency.getName(), currency.getSymbol()))
                                );
                countryCurrenciesRepository.save(new CountryCurrencies(new CountryCurrenciesId(countryId, savedCurrency.getId())));
            }

            for(Capital capital: country.getCapital()){
                Capital savedCapital =
                        capitalRepository.findByName(capital.getName())
                                .orElseGet(() ->
                                        capitalRepository.save(new Capital(null, capital.getName()))
                                );
                countryCapitalsRepository.save(new CountryCapitals(new CountryCapitalsId(countryId, savedCapital.getId())));
            }

            for(Language language: country.getLanguages()){
                Language savedLanguage =
                        languageRepository.findByCode(language.getCode())
                                .orElseGet(() ->
                                        languageRepository.save(new Language(null, language.getCode(), language.getName()))
                                );
                countryLanguagesRepository.save(new CountryLanguages(new CountryLanguagesId(countryId, savedLanguage.getId())));
            }

            for(Border border: country.getBorders()){
                Border savedBorder =
                        borderRepository.findByName(border.getName())
                                .orElseGet(() ->
                                        borderRepository.save(new Border(null, border.getName()))
                                );
                countryBordersRepository.save(new CountryBorders(new CountryBordersId(countryId, savedBorder.getId())));
            }

            for(TimeZone timeZone: country.getTimeZones()){
                TimeZone savedTimeZone =
                        timeZoneRepository.findByName(timeZone.getName())
                                .orElseGet(() ->
                                        timeZoneRepository.save(new TimeZone(null, timeZone.getName()))
                                );
                countryTimeZonesRepository.save(new CountryTimeZones(new CountryTimeZonesId(countryId, savedTimeZone.getId())));
            }
        }
    }
}
