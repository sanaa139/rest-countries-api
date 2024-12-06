package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryBordersId;
import dev.sana.volvorecruitementtask.entity.bridgetables.CountryBorders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryBordersRepository extends JpaRepository<CountryBorders, CountryBordersId> {
    @Query("""
        SELECT c FROM CountryBorders c WHERE c.id.countryId = :countryId AND c.id.borderId = :borderId
    """)
    Optional<CountryBorders> findByCountryIdAndBorderId(@Param("countryId") Integer countryId, @Param("borderId") Integer borderId);
}
