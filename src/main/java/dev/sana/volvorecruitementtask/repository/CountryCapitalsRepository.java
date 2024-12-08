package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryCapitals;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryCapitalsId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryCapitalsRepository extends JpaRepository<CountryCapitals, CountryCapitalsId> {
}
