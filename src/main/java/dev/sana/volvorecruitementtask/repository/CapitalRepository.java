package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CapitalRepository extends JpaRepository<Capital, Integer> {
    Optional<Capital> findByName(@Param("name") String name);
}
