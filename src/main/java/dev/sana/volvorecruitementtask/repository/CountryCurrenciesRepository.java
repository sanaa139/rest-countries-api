package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.CountryCurrencies;
import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryCurrenciesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryCurrenciesRepository extends JpaRepository<CountryCurrencies, CountryCurrenciesId> {
    @Query("""
        SELECT c FROM CountryCurrencies c WHERE c.id.countryId = :countryId AND c.id.currencyId = :currencyId
    """)
    Optional<CountryCurrencies> findByCountryIdAndCurrencyId(@Param("countryId") Integer countryId, @Param("currencyId") Integer currencyId);
}
