package dev.sana.volvorecruitementtask.entity.bridgetables.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CountryLanguagesId implements Serializable {
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "language_id")
    private Integer languageId;

    public CountryLanguagesId(Integer countryId, Integer languageId) {
        this.countryId = countryId;
        this.languageId = languageId;
    }

    public CountryLanguagesId() {}

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
}
