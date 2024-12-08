package dev.sana.volvorecruitementtask.entity.bridgetables;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryBordersId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country_borders")
public class CountryBorders {
    @EmbeddedId
    private CountryBordersId id;

    public CountryBorders(CountryBordersId id) {
        this.id = id;
    }

    public CountryBorders() {}

    public CountryBordersId getId() {
        return id;
    }

    public void setId(CountryBordersId id) {
        this.id = id;
    }
}
