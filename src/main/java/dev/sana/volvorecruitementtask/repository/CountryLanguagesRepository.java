package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryLanguages;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryLanguagesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguagesRepository extends JpaRepository<CountryLanguages, CountryLanguagesId> {
}
