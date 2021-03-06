package com.carcompare.repository;

import com.carcompare.entities.AutoMaker;
import org.springframework.data.repository.CrudRepository;

public interface AutoMakerRepository  extends CrudRepository<AutoMaker, Long> {
	
	AutoMaker findById(long id);

}
