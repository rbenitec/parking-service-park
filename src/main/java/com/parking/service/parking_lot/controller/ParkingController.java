package com.parking.service.parking_lot.controller;

import com.parking.service.parking_lot.controller.dto.*;
import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.service.ParkingService;
import com.parking.service.parking_lot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/campus/park/all-places")
    public ResponseParkingDto getParkingAndPlacesByCampus(@RequestBody RequestCampusPark campusPark){
        return parkingService.getParkingByCampus(campusPark);
    }
    @GetMapping("/dashboard/park/available")
    public List<ParkingCampusDto> getParkingAndPlacesAvailable(){
        return parkingService.getParkingByCampus();
    }

    @GetMapping("/get-place/{parking-id}")
    public ResponseEntity<Place> getPlace(@PathVariable("parking-id") Integer parkingId,
                                          @Param("series") String series,
                                          @Param("basement") String basement){
        Optional<Place> place =  placeService.getPlace(series, basement, parkingId);
        return place.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/created/park")
    public Parking createdPark(@RequestBody RequestParkingDto parkingDto){
        return parkingService.saveParking(parkingDto);
    }
    @PostMapping("/created/place")
    public Place createPlace (@RequestBody RequestPlaceDto placeDto){
        return placeService.savePlace(placeDto);
    }
}
