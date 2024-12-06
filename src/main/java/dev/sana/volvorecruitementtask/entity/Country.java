package dev.sana.volvorecruitementtask.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameCommon;
    private String nameOfficial;

    @ManyToMany
    @JoinTable(
            name = "country_currencies",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_id")
    )
    private List<Currency> currencies;

    @ManyToMany
    @JoinTable(
            name = "country_capitals",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "capital_id")
    )
    private List<Capital> capitals;

    private String region;
    private String subregion;

    @ManyToMany
    @JoinTable(
            name = "country_languages",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;

    private int population;

    @ManyToMany
    @JoinTable(
            name = "country_borders",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "border_id")
    )
    private List<Border> borders;

    @ManyToMany
    @JoinTable(
            name = "country_time_zones",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "time_zone_id")
    )
    private List<TimeZone> timeZones;

    public Country(Integer id, String nameCommon, String nameOfficial, List<Currency> currencies, List<Capital> capitals, String region, String subregion, List<Language> languages, int population, List<Border> borders, List<TimeZone> timeZones) {
        this.id = id;
        this.nameCommon = nameCommon;
        this.nameOfficial = nameOfficial;
        this.currencies = currencies;
        this.capitals = capitals;
        this.region = region;
        this.subregion = subregion;
        this.languages = languages;
        this.population = population;
        this.borders = borders;
        this.timeZones = timeZones;
    }

    public Country(Integer id, String nameCommon, String nameOfficial, String region, String subregion, int population) {
        this.id = id;
        this.nameCommon = nameCommon;
        this.nameOfficial = nameOfficial;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
    }

    public Country() {
    }

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

    public List<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<Capital> capitals) {
        this.capitals = capitals;
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

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", nameCommon='" + nameCommon + '\'' +
                ", nameOfficial='" + nameOfficial + '\'' +
                ", currencies=" + currencies +
                ", capitals=" + capitals +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", languages=" + languages +
                ", population=" + population +
                ", borders=" + borders +
                ", timeZones=" + timeZones +
                '}';
    }
}
