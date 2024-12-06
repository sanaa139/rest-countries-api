package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryTimeZones;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryTimeZonesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryTimeZonesRepository extends JpaRepository<CountryTimeZones, CountryTimeZonesId> {
    @Query("""
        SELECT c FROM CountryTimeZones c WHERE c.id.countryId = :countryId AND c.id.timeZoneId = :timeZoneId
    """)
    Optional<CountryTimeZones> findByCountryIdAndTimeZoneId(@Param("countryId") Integer countryId, @Param("timeZoneId") Integer timeZoneId);
}
