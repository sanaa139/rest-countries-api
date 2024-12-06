package dev.sana.volvorecruitementtask.DTO;

import java.util.List;
import java.util.Map;

public class CountryDTO {
    private NameDTO name;
    private Map<String, CurrencyDTO> currencies;
    private List<String> capital;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private Integer population;
    private List<String> borders;
    private List<String> timezones;

    public CountryDTO(){}

    public CountryDTO(NameDTO name, Map<String, CurrencyDTO> currencies, List<String> capital, String region, String subregion, Map<String, String> languages, Integer population, List<String> borders, List<String> timezones) {
        this.name = name;
        this.currencies = currencies;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.languages = languages;
        this.population = population;
        this.borders = borders;
        this.timezones = timezones;
    }

    public NameDTO getName() {
        return name;
    }

    public void setName(NameDTO name) {
        this.name = name;
    }

    public Map<String, CurrencyDTO> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, CurrencyDTO> currencies) {
        this.currencies = currencies;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "name=" + name +
                ", currencies=" + currencies +
                ", capital=" + capital +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", languages=" + languages +
                ", population=" + population +
                ", borders=" + borders +
                ", timezones=" + timezones +
                '}';
    }
}
