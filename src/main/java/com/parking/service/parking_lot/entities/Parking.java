package com.parking.service.parking_lot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String campus;
    private String direction;
    private String link; //Link de direccion de google maps
    @Column(name = "quantity_places")
    private Integer quantityPlaces; //FK
}
