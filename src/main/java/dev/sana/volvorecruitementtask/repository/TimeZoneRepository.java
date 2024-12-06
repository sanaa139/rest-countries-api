package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.TimeZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeZoneRepository extends JpaRepository<TimeZone, Integer> {
    Optional<TimeZone> findByName(String name);
}
