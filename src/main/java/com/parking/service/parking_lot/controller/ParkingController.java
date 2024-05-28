package com.parking.service.parking_lot.controller;

import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.service.ParkingService;
import com.parking.service.parking_lot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;
    private final PlaceService placeService;

    @GetMapping("/all")
    public ResponseEntity<List<Parking>> getAllParking(){
        List<Parking> parkings = parkingService.getAllParking();
        if(!parkings.isEmpty()){
            return ResponseEntity.ok(parkings);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/get-park")
    public ResponseEntity<Place> getPlace(@Param("campus") String campus,
                                                @Param("series") String series){
        Optional<Place> place =  placeService.getPlace(campus, series);
        return place.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
