package com.carcompare.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="CAR_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long id_car_detail;
    private Integer  price;
    private String TurType;
    private int places;
    private Integer length;
    private Integer width;
    private Integer height;
    private String gearbox;
    private String fuel;

}
