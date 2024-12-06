package dev.sana.volvorecruitementtask.entity.bridgetables;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryLanguagesId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country_languages")
public class CountryLanguages {
    @EmbeddedId
    private CountryLanguagesId id;

    public CountryLanguages(CountryLanguagesId id) {
        this.id = id;
    }

    public CountryLanguages() {
    }

    public CountryLanguagesId getId() {
        return id;
    }

    public void setId(CountryLanguagesId id) {
        this.id = id;
    }
}
