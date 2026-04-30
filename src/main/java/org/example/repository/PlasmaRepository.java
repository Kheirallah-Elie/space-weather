package org.example.repository;

import org.example.models.PlasmaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PlasmaRepository extends JpaRepository<PlasmaData, Long> {
    @Modifying
    @Query(value = """
        INSERT INTO plasma_data (timestamp, density, speed, temperature)
        VALUES (:timestamp, :density, :speed, :temperature)
        ON CONFLICT (timestamp)
        DO UPDATE SET
            density = EXCLUDED.density,
            speed = EXCLUDED.speed,
            temperature = EXCLUDED.temperature
        """, nativeQuery = true)
    void upsert(
            LocalDateTime timestamp,
            Double density,
            Double speed,
            Double temperature
    );
}
