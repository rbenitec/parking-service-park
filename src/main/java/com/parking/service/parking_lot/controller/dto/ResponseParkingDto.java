package com.parking.service.parking_lot.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.parking.service.parking_lot.entities.Place;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseParkingDto {
    private String campus;
    private String direction;
    private String link; //Link de direccion de google maps
    private Integer quantityPlaces;
    private List<Place> places;
}
