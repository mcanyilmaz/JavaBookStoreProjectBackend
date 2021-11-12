package com.bookApplication2.BookApplication2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookApplication2.BookApplication2.model.Slider;

public interface SliderRepository extends JpaRepository<Slider, Integer> {
	
	List<Slider> findAllSliderByStateTrue();
	
	List<Slider> findAllSliderByStateTrueOrderByLineNumberAsc();
	
	Slider findByLineNumber(int lineNumber);

}
