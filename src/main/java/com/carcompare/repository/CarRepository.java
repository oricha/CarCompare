package com.carcompare.repository;

import com.carcompare.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface CarRepository  extends CrudRepository<Car, Long> {

	Car findCarById(long id);
	Collection<Car> findCarsById(List<Long> ids);

}
