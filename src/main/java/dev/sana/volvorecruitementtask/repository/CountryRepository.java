package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("""
        SELECT c FROM Country c WHERE c.nameCommon = :commonName AND
        c.nameOfficial = :officialName AND
        c.region = :region AND
        c.subregion = :subregion AND
        c.population = :population
    """)
    Optional<Country> findByAllData(@Param("commonName") String commonName,
                                    @Param("officialName") String officialName,
                                    @Param("region") String region,
                                    @Param("subregion") String subregion,
                                    @Param("population") Integer population);

    @Query("""
    SELECT c FROM Country c JOIN FETCH c.currencies WHERE c.id = :id
    """)
    List<Country> getCurrenciesById(@Param("id") Integer id);
}
