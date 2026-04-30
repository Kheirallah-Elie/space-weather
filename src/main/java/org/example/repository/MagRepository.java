package org.example.repository;

import org.example.models.MagData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MagRepository extends JpaRepository<MagData, Long> {
    @Modifying
    @Query(value = """
        INSERT INTO mag_data (timestamp, bx, by, bz, lon, lat, bt)
        VALUES (:timestamp, :bx, :by, :bz, :lon, :lat, :bt)
        ON CONFLICT (timestamp)
        DO UPDATE SET
            bx = EXCLUDED.bx,
            by = EXCLUDED.by,
            bz = EXCLUDED.bz,
            lon = EXCLUDED.lon,
            lat = EXCLUDED.lat,
            bt = EXCLUDED.bt
        """, nativeQuery = true)
    void upsert(
            LocalDateTime timestamp,
            Double bx,
            Double by,
            Double bz,
            Double lon,
            Double lat,
            Double bt
    );
}