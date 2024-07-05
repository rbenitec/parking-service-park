package com.parking.service.parking_lot.service;

import com.parking.service.parking_lot.controller.dto.RequestPlaceDto;
import com.parking.service.parking_lot.entities.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    Optional<Place> getPlace (String series,String basement, Integer parkingId);
    List<Place>  getPlacesByCampusAndAvailable(Integer parkingId);
    List<Place> getAllPlace();
    List<Place> getAllPlaceByParkingId(Integer parkingId);
    Place savePlace(RequestPlaceDto place);
    Optional<Place> updatePlace (Integer idPlace);
    //Optional<Place> reservePlace (String campus, String series);
    //Optional<Place> releasePlace (String campus, String series);
}
