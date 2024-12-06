package dev.sana.volvorecruitementtask.entity.bridgetables.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CountryTimeZonesId implements Serializable {
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "time_zone_id")
    private Integer timeZoneId;

    public CountryTimeZonesId(Integer countryId, Integer timeZoneId) {
        this.countryId = countryId;
        this.timeZoneId = timeZoneId;
    }

    public CountryTimeZonesId() {
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(Integer timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}
