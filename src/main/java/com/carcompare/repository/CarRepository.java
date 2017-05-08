package com.carcompare.repository;

import com.carcompare.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository  extends CrudRepository<Car, Long> {

	Car findCarById(long id);

}
