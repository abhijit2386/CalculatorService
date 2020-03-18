package com.calc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArithmaticService extends CrudRepository<Calculator, Integer>{


	@Query(value = "from Calculator")
	public List<Calculator> findAllCalc();

}
