package com.parking.service.parking_lot.service;

import com.parking.service.parking_lot.entities.Place;

import java.util.Optional;

public interface PlaceService {
    Optional<Place> getPlace (String campus, String series);
    //Optional<Place> reservePlace (String campus, String series);
    //Optional<Place> releasePlace (String campus, String series);
}
