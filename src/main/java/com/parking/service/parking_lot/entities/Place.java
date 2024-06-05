package com.parking.service.parking_lot.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String series;
    private String basement; //sotano
    private Integer status;
    private Integer available;
    @Column(name = "parking_id")
    private Integer parkingId;
}
