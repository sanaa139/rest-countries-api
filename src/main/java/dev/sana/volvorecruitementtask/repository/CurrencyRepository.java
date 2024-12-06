package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findByCode(String code);
    Optional<Currency> findByName(String name);
    Optional<Currency> findBySymbol(String symbol);
}
