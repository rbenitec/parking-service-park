package com.parking.service.parking_lot.service.impl;

import com.parking.service.parking_lot.controller.dto.RequestPlaceDto;
import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.repository.PlaceRepository;
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
                .available(true)
                .basement(placeDto.getBasement())
                .parkingId(placeDto.getParkingId())
                .series(placeDto.getSeries())
                .parkingId(placeDto.getParkingId())
                .status(true)
                .build();
        return placeRepository.save(place);
    }
}
