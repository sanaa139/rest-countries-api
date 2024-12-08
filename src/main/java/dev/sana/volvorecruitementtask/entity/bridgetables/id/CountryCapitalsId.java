package dev.sana.volvorecruitementtask.entity.bridgetables.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CountryCapitalsId implements Serializable {
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "capital_id")
    private Integer capitalId;

    public CountryCapitalsId(Integer countryId, Integer capitalId) {
        this.countryId = countryId;
        this.capitalId = capitalId;
    }

    public CountryCapitalsId() {}

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
    }
}
