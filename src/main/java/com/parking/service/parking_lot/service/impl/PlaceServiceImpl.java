package com.parking.service.parking_lot.service.impl;

import com.parking.service.parking_lot.controller.dto.RequestPlaceDto;
import com.parking.service.parking_lot.entities.Parking;
import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.repository.PlaceRepository;
import com.parking.service.parking_lot.service.ParkingService;
import com.parking.service.parking_lot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public Optional<Place> getPlace(String series,String basement, Integer parkingId) {
        return placeRepository.getPlaceByCampus(series, basement, parkingId);
    }

    @Override
    public List<Place> getPlacesByCampusAndAvailable(Integer parkingId) {
        return placeRepository.getPlacesByCampusAndAvailable(parkingId);
    }

    @Override
    public List<Place> getAllPlace() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> getAllPlaceByParkingId(Integer parkingId) {
        return placeRepository.getPlacesByParkingId(parkingId);
    }

    @Override
    public Place savePlace(RequestPlaceDto placeDto) {
        Place place = Place.builder()
                .available(1)
                .basement(placeDto.getBasement())
                .parkingId(placeDto.getParkingId())
                .series(placeDto.getSeries())
                .parkingId(placeDto.getParkingId())
                .status(1)
                .build();
        return placeRepository.save(place);
    }

    @Override
    public Optional<Place> updatePlace(Integer idPlace) {
        Optional<Place> place = placeRepository.findById(idPlace);
        if (place.isPresent()) {
            place.get().setAvailable(0);
            return Optional.of(placeRepository.save(place.get()));
        }
        return place;
    }
}
