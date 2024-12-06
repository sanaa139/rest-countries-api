package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryCapitals;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryCapitalsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryCapitalsRepository extends JpaRepository<CountryCapitals, CountryCapitalsId> {
    @Query("""
        SELECT c FROM CountryCapitals c WHERE c.id.countryId = :countryId AND c.id.capitalId = :capitalId
    """)
    Optional<CountryCapitals> findByCountryIdAndCapitalId(@Param("countryId") Integer countryId, @Param("capitalId") Integer capitalId);
}
