package com.parking.service.parking_lot.service.impl;

import com.parking.service.parking_lot.controller.dto.ParkingCampusDto;
import com.parking.service.parking_lot.controller.dto.RequestCampusPark;
import com.parking.service.parking_lot.controller.dto.RequestParkingDto;
import com.parking.service.parking_lot.controller.dto.ResponseParkingDto;
import com.parking.service.parking_lot.controller.response.ResponseSlots;
import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.repository.ParkingRepository;
import com.parking.service.parking_lot.service.ParkingService;
import com.parking.service.parking_lot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;
    private final PlaceService placeService;

    @Override
    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }

    @Override
    public ResponseParkingDto getParkingByRequestCampus(RequestCampusPark campus) {
        List<Place> places = placeService.getAllPlaceByParkingId(campus.getParkingId());
        Optional<Parking> parking = parkingRepository.getParkingByCampus(campus.getCampus());
        return parking.map(value -> buildResponseParking(value, places)).orElse(null);
    }

    @Override
    public List<ParkingCampusDto> getAllParkingByCampus() {
        return buildParkingCampus(parkingRepository.findAll());

    }
    @Override
    public Optional<ResponseSlots> getPlaceAutoAssigned(String campus) {
        Optional<Parking> parking = parkingRepository.getParkingByCampus(campus);
        if(parking.isPresent()){
            List<Place> places = placeService.getAllPlaceByParkingId(parking.get().getId());
            return buildResponseSlots(places);
        }else {
            return null;
        }
    }

    private Optional<ResponseSlots> buildResponseSlots(List<Place> places) {
        long totalSlots = places.size();
        long availableSlots = places.stream().filter(place -> place.getAvailable()==1).count();
        Optional<Place> place = places.stream().filter(place1 -> place1.getAvailable()==1).findAny();
        if(place.isPresent()){
            //Reserv el lugar poniendo el available en cero
            //placeService.updatePlace(place.get().getId());
            //Build the response
            return Optional.of(ResponseSlots.builder()
                    .totalSlots(totalSlots)
                    .availableSlots(availableSlots)
                    .idSlot(place.get().getId())
                    .basement(place.get().getBasement())
                    .series(place.get().getSeries())
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Parking> getParkingByCampus(String campus) {
        return parkingRepository.getParkingByCampus(campus);
    }

    private List<ParkingCampusDto> buildParkingCampus(List<Parking> parkings) {
        ArrayList<ParkingCampusDto> parkingCampusDtos = new ArrayList<>();
        parkings.forEach(parking -> {
            List<Place> places = placeService.getAllPlaceByParkingId(parking.getId());
            Long quantityAvailableSpots = places.stream().filter(place -> place.getAvailable()==1).count();
            ParkingCampusDto parkingCampusDto = ParkingCampusDto.builder()
                    .campus(parking.getCampus())
                    .direction(parking.getDirection())
                    .link(parking.getLink())
                    .quantityPlaces(parking.getQuantityPlaces())
                    .availableSpot(quantityAvailableSpots)
                    .build();
            parkingCampusDtos.add(parkingCampusDto);
        });
        return parkingCampusDtos;
    }

    private ResponseParkingDto buildResponseParking(Parking parking, List<Place> places) {
        return ResponseParkingDto.builder()
                .campus(parking.getCampus())
                .direction(parking.getDirection())
                .quantityPlaces(parking.getQuantityPlaces())
                .link(parking.getLink())
                .places(places)
                .build();
    }

    @Override
    public Parking saveParking(RequestParkingDto parkingDto) {
        Parking parking = Parking.builder()
                .campus(parkingDto.getCampus())
                .direction(parkingDto.getDirection())
                .link(parkingDto.getLink())
                .quantityPlaces(parkingDto.getQuantityPlaces())
                .build();
        return parkingRepository.save(parking);
    }

}
