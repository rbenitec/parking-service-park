package com.parking.service.parking_lot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSlots {
     private Long totalSlots;
     private Long availableSlots;
     private Integer idSlot;
     private String basement;
     private String series;
}
