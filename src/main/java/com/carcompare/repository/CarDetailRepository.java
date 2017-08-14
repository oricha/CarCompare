package com.carcompare.repository;

import com.carcompare.entities.CarDetail;
import org.springframework.data.repository.CrudRepository;

public interface CarDetailRepository extends CrudRepository<CarDetail, Long> {

    CarDetail findById(long id);
    CarDetail findById_car_detail(long id_car_detail);
}
