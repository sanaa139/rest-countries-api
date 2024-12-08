package dev.sana.volvorecruitementtask.repository;

import dev.sana.volvorecruitementtask.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByCode(@Param("name") String code);
}
