package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryCurrencies;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryCurrenciesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCurrenciesRepository extends JpaRepository<CountryCurrencies, CountryCurrenciesId> {
}
