package com.parking.service.parking_lot.service;

import com.parking.service.parking_lot.controller.dto.ParkingCampusDto;
import com.parking.service.parking_lot.controller.dto.RequestCampusPark;
import com.parking.service.parking_lot.controller.dto.RequestParkingDto;
import com.parking.service.parking_lot.controller.dto.ResponseParkingDto;
import com.parking.service.parking_lot.controller.response.ResponseSlots;
import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface ParkingService {

    List<Parking> getAllParking();
    ResponseParkingDto getParkingByRequestCampus(RequestCampusPark campus);
    List<ParkingCampusDto> getAllParkingByCampus();
    Optional<Parking> getParkingByCampus(String campus);
    Optional<ResponseSlots> getPlaceAutoAssigned(String campus);
    Parking saveParking (RequestParkingDto parking);
}
