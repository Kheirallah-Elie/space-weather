package org.example.repository;

import org.example.models.MagData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MagRepository extends JpaRepository<MagData, Long> {
    Optional<MagData> findByTimestamp(LocalDateTime timestamp);

}
