package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.bridgetables.id.CountryBordersId;
import dev.sana.volvorecruitementtask.entity.bridgetables.CountryBorders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryBordersRepository extends JpaRepository<CountryBorders, CountryBordersId> {
}
