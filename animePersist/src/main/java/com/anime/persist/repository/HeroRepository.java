package com.anime.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anime.persist.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer>{
	
	@Query("select h from Hero h where h.name like %?1%") 
	List<Hero> findByName(String name);

}
