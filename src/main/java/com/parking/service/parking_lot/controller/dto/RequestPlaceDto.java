package com.parking.service.parking_lot.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestPlaceDto {
    private String series;
    private String basement; //sotano
    private Boolean status;
    private Boolean available;
    private Integer parkingId;
}
