package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryTimeZones;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryTimeZonesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryTimeZonesRepository extends JpaRepository<CountryTimeZones, CountryTimeZonesId> {
}
