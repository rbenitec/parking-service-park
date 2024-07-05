package com.parking.service.parking_lot.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestParkingDto {
    private String campus;
    private String direction;
    private String link; //Link de direccion de google maps
    private Integer quantityPlaces;
}
