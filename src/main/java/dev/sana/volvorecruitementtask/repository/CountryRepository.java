package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByCca3(@Param("cca3") String cca3);
}
