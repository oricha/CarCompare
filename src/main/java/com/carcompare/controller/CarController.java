package com.carcompare.controller;

import com.carcompare.entities.AutoMaker;
import com.carcompare.entities.Car;
import com.carcompare.repository.AutoMakerRepository;
import com.carcompare.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private AutoMakerRepository autoMakerRepository;
	
	/**
	 * Find car by Id
	 * GET /car/$transaction_id
	 * Returns: { "amount":double,"type":string,"parent_id":long } 
	 * @return
	 */
	@RequestMapping(value = "/{car_id}", method = RequestMethod.GET)
	public @ResponseBody Car getCar(@PathVariable long car_id){
		
		return carRepository.findCarById(car_id);
	}
	
	/**
	 * Compare cars by Ids
	 * GET /car/$transaction_id
	 * Returns: { "amount":double,"type":string,"parent_id":long } 
	 * @return
	 */
	@RequestMapping(value = "/{car_id1}/{car_id2}", method = RequestMethod.GET)
	public @ResponseBody Iterable<Car> compareCars(@PathVariable long car_id1, @PathVariable long car_id2){
		List<Long> list = new ArrayList<>();
		list.add(car_id1);
		list.add(car_id2);
		return carRepository.findCarsById(list);
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/brands", method = RequestMethod.GET)
	public @ResponseBody Iterable<AutoMaker> listAutoMakers(){
		
		return autoMakerRepository.findAll();
	}

	public CarRepository getCarRepository() {
		return carRepository;
	}

	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	
}
