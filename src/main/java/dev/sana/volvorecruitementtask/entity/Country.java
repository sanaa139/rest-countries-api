package dev.sana.volvorecruitementtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sana.volvorecruitementtask.DTO.CountryDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String nameCommon;
    private String nameOfficial;
    private String cca3;

    @ManyToMany
    @JoinTable(
            name = "country_currencies",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_id")
    )
    private List<Currency> currencies = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "country_capitals",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "capital_id")
    )
    private List<Capital> capital = new ArrayList<>();

    private String region;
    private String subregion;

    @ManyToMany
    @JoinTable(
            name = "country_languages",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();

    private int population;

    @ManyToMany
    @JoinTable(
            name = "country_borders",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "border_id")
    )
    private List<Border> borders = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "country_time_zones",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "time_zone_id")
    )
    private List<TimeZone> timeZones = new ArrayList<>();

    public Country(Integer id, String nameCommon, String nameOfficial, String cca3, String region, String subregion, int population) {
        this.id = id;
        this.nameCommon = nameCommon;
        this.nameOfficial = nameOfficial;
        this.cca3 = cca3;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
    }

    public Country(CountryDTO countryDTO){
        this.id = null;
        this.nameCommon = countryDTO.getName().getCommon();
        this.nameOfficial = countryDTO.getName().getOfficial();
        this.cca3 = countryDTO.getCca3();
        this.region = countryDTO.getRegion();
        this.subregion = countryDTO.getSubregion();
        this.population = countryDTO.getPopulation();

        countryDTO.getCurrencies().keySet().forEach(currencyCode -> this.currencies.add(new Currency(null, currencyCode, countryDTO.getCurrencies().get(currencyCode).getName(), countryDTO.getCurrencies().get(currencyCode).getSymbol())));
        countryDTO.getCapital().forEach(capitalName -> this.capital.add(new Capital(null, capitalName)));
        countryDTO.getLanguages().keySet().forEach(languageCode -> this.languages.add(new Language(null, languageCode, countryDTO.getLanguages().get(languageCode))));
        countryDTO.getBorders().forEach(borderName -> this.borders.add(new Border(null, borderName)));
        countryDTO.getTimezones().forEach(timeZone -> this.timeZones.add(new TimeZone(null, timeZone)));
    }

    public Country() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCommon() {
        return nameCommon;
    }

    public void setNameCommon(String nameCommon) {
        this.nameCommon = nameCommon;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial = nameOfficial;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Capital> getCapital() {
        return capital;
    }

    public void setCapital(List<Capital> capital) {
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

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Border> getBorders() {
        return borders;
    }

    public void setBorders(List<Border> borders) {
        this.borders = borders;
    }

    public List<TimeZone> getTimeZones() {
        return timeZones;
    }

    public void setTimeZones(List<TimeZone> timeZones) {
        this.timeZones = timeZones;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String ccca3) {
        this.cca3 = ccca3;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", nameCommon='" + nameCommon + '\'' +
                ", nameOfficial='" + nameOfficial + '\'' +
                ", cca3='" + cca3 + '\'' +
                ", currencies=" + currencies +
                ", capital=" + capital +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", languages=" + languages +
                ", population=" + population +
                ", borders=" + borders +
                ", timeZones=" + timeZones +
                '}';
    }
}
