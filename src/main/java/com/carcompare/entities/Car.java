package com.carcompare.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="CAR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long id_automaker;
	private String model;
	private Integer year;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_car_detail")
	private CarDetail detail;

}
