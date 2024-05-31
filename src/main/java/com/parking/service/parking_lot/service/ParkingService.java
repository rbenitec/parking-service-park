package com.parking.service.parking_lot.service;

import com.parking.service.parking_lot.controller.dto.RequestCampusPark;
import com.parking.service.parking_lot.controller.dto.RequestParkingDto;
import com.parking.service.parking_lot.controller.dto.ResponseParkingDto;
import com.parking.service.parking_lot.entities.Parking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ParkingService {

    List<Parking> getAllParking();
    ResponseParkingDto getParkingByCampus(RequestCampusPark campus);
    Parking saveParking (RequestParkingDto parking);
}
