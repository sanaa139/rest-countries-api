package dev.sana.volvorecruitementtask.entity.bridgetables.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CountryCurrenciesId implements Serializable {
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "currency_id")
    private Integer currencyId;

    public CountryCurrenciesId(Integer countryId, Integer currencyId) {
        this.countryId = countryId;
        this.currencyId = currencyId;
    }

    public CountryCurrenciesId() {

    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }
}
