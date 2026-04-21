package org.example.repository;

import org.example.models.SolarSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SolarSnapshotRepository extends JpaRepository<SolarSnapshot, Long> {

    Optional<SolarSnapshot> findByTimestamp(LocalDateTime timestamp);
}