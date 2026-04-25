package org.example.repository;

import org.example.models.KpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface KpRepository extends JpaRepository<KpData, Long> {
    Optional<KpData> findByTimestamp(LocalDateTime timestamp);

}
