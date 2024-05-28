package com.parking.service.parking_lot.service;

import com.parking.service.parking_lot.entities.Parking;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParkingService {

    List<Parking> getAllParking();
    List<Parking> getParkingByCampus(String campus);
}
