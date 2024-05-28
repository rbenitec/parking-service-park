package com.parking.service.parking_lot.repository;

import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    @Query(value = "select * from parking where campus: = campus", nativeQuery = true)
    Place getParkingByCampus (@Param("campos") String campus);
}
