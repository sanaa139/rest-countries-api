package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.Border;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BorderRepository extends JpaRepository<Border, Integer> {
    Optional<Border> findByName(@Param("name") String name);
}
