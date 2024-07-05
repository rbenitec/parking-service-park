package com.parking.service.parking_lot.repository;

import com.parking.service.parking_lot.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    @Query(value = "select * from place where series = :series and basement = :basement and parking_id = :parkingId", nativeQuery = true)
    Optional<Place> getPlaceByCampus (@Param("series") String series,
                                      @Param("basement") String basement,
                                     @Param("parkingId") Integer parkingId);

    @Query(value = "select * from place where parking_id = :parkingId", nativeQuery = true)
    List<Place> getPlacesByParkingId (@Param("parkingId") Integer parkingId);

    @Query(value = "select * from place where parking_id = :parkingId and available = 1", nativeQuery = true)
    List<Place> getPlacesByCampusAndAvailable (@Param("parkingId") Integer parkingId);
}
