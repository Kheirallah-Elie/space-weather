package org.example.repository;

import org.example.models.KpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface KpRepository extends JpaRepository<KpData, Long> {
    @Modifying
    @Query(value = """
        INSERT INTO kp_data (timestamp, kp, type, noaa_scale)
        VALUES (:timestamp, :kp, :type, :noaa_scale)
        ON CONFLICT (timestamp)
        DO UPDATE SET
            kp = EXCLUDED.kp,
            type = EXCLUDED.type,
            noaa_scale = EXCLUDED.noaa_scale
        """, nativeQuery = true)
    void upsert(
            Instant timestamp,
            Double kp,
            String type,
            String noaa_scale
    );

}

