package com.parking.service.parking_lot.repository;

import com.parking.service.parking_lot.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    @Query(value = "select * from places where campus: = campus and series: =series", nativeQuery = true)
    Optional<Place> getPlaceByCampus (@Param("campos") String campus,
                                     @Param("series") String series);
}
