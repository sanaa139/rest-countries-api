package dev.sana.volvorecruitementtask.entity.bridgetables.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CountryBordersId implements Serializable {
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "border_id")
    private Integer borderId;

    public CountryBordersId(Integer countryId, Integer borderId) {
        this.countryId = countryId;
        this.borderId = borderId;
    }

    public CountryBordersId() {}

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getBorderId() {
        return borderId;
    }

    public void setBorderId(Integer borderId) {
        this.borderId = borderId;
    }
}
