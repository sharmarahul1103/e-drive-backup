package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.WikiMediaData;

public interface WikiDataRepo extends JpaRepository<WikiMediaData, Integer>{

	
	
	
}
