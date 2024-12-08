package dev.sana.volvorecruitementtask.entity.bridgetables;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryCurrenciesId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country_currencies")
public class CountryCurrencies {
    @EmbeddedId
    private CountryCurrenciesId id;

    public CountryCurrencies(CountryCurrenciesId id) {
        this.id = id;
    }

    public CountryCurrencies() {}

    public CountryCurrenciesId getId() {
        return id;
    }

    public void setId(CountryCurrenciesId id) {
        this.id = id;
    }
}
