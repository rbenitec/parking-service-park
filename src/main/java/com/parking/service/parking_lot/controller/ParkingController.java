package com.parking.service.parking_lot.controller;

import com.parking.service.parking_lot.controller.dto.*;
import com.parking.service.parking_lot.controller.response.ResponseSlots;
import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.service.ParkingService;
import com.parking.service.parking_lot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;
    private final PlaceService placeService;

    @GetMapping("/all")
    public ResponseEntity<List<Parking>> getAllParking(){
        log.info("Call getAllParking");
        List<Parking> parkings = parkingService.getAllParking();
        if(!parkings.isEmpty()){
            return ResponseEntity.ok(parkings);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/campus/park/all-places")
    public ResponseParkingDto getParkingAndPlacesByCampus(@RequestBody RequestCampusPark campusPark){
        log.info("Call getParkingAndPlacesByCampus: {}", campusPark);
        return parkingService.getParkingByRequestCampus(campusPark);
    }
    @GetMapping("/dashboard/park/available")
    public ResponseDto getParkingAndPlacesAvailable(){
        log.info("Call getParkingAndPlacesAvailable");
        return ResponseDto.builder()
                .parkingCampus(parkingService.getAllParkingByCampus())
                .build();
    }

    @GetMapping("/get-place/{parking-id}")
    public ResponseEntity<Place> getPlace(@PathVariable("parking-id") Integer parkingId,
                                          @Param("series") String series,
                                          @Param("basement") String basement){
        Optional<Place> place =  placeService.getPlace(series, basement, parkingId);
        return place.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Metodo, para autoasignar un espacio.
     * @param campus
     * @return
     */
    @GetMapping("/assigned-place/{campus}")
    public ResponseEntity<ResponseSlots> getPlaceAutoAssigned(@PathVariable("campus") String campus){
        Optional<ResponseSlots> place =  parkingService.getPlaceAutoAssigned(campus);
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

    @PatchMapping("/update/lot/{idPlace}")
    public ResponseEntity<Place> updatePlaceParking (@PathVariable("idPlace") Integer idPlace) {
        Optional<Place> place = placeService.updatePlace(idPlace);
        return place
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
