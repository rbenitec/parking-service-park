package com.parking.service.parking_lot.service.impl;

import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private final ParkingService parkingService;

    @Override
    public List<Parking> getAllParking() {
        return parkingService.getAllParking();
    }

    @Override
    public List<Parking> getParkingByCampus(String campus) {
        return parkingService.getParkingByCampus(campus);
    }
}
