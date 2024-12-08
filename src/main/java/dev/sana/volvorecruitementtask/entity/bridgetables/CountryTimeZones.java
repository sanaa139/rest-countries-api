package dev.sana.volvorecruitementtask.entity.bridgetables;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryTimeZonesId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country_time_zones")
public class CountryTimeZones {
    @EmbeddedId
    private CountryTimeZonesId id;

    public CountryTimeZones(CountryTimeZonesId id) {
        this.id = id;
    }

    public CountryTimeZones() {}

    public CountryTimeZonesId getId() {
        return id;
    }

    public void setId(CountryTimeZonesId id) {
        this.id = id;
    }
}
