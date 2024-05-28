package com.parking.service.parking_lot.entities;

import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@Table(name = "parking")
public class Parking {
    @Id
    private Integer id;
    private String campus;
    private String direction;
    private String link; //Link de direccion de google maps
    private Integer place; //FK
}
