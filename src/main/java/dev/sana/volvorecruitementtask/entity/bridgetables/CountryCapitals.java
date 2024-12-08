package dev.sana.volvorecruitementtask.entity.bridgetables;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryCapitalsId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country_capitals")
public class CountryCapitals {
    @EmbeddedId
    private CountryCapitalsId id;

    public CountryCapitals(CountryCapitalsId id) {
        this.id = id;
    }

    public CountryCapitals() {}

    public CountryCapitalsId getId() {
        return id;
    }

    public void setId(CountryCapitalsId id) {
        this.id = id;
    }
}
