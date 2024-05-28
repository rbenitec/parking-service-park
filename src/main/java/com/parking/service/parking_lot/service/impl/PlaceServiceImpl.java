package com.parking.service.parking_lot.service.impl;

import com.parking.service.parking_lot.entities.Place;
import com.parking.service.parking_lot.repository.PlaceRepository;
import com.parking.service.parking_lot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public Optional<Place> getPlace(String campus, String series) {
        return placeRepository.getPlaceByCampus(campus, series);
    }
}
