package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryLanguages;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryLanguagesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryLanguagesRepository extends JpaRepository<CountryLanguages, CountryLanguagesId> {
    @Query("""
        SELECT c FROM CountryLanguages c WHERE c.id.countryId = :countryId AND c.id.languageId = :languageId
    """)
    Optional<CountryLanguages> findByCountryIdAndLanguageId(@Param("countryId") Integer countryId, @Param("languageId") Integer languageId);
}
