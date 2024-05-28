package com.parking.service.parking_lot.entities;

import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "place")
public class Place {
    private Integer id;
    private Integer campus;
    private String series;
    private String basement; //sotano
    private Boolean status;
    private Boolean available;
}
