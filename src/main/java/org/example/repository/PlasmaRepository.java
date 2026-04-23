package org.example.repository;

import org.example.models.PlasmaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PlasmaRepository extends JpaRepository<PlasmaData, Long> {
    Optional<PlasmaData> findByTimestamp(LocalDateTime timestamp);
}
