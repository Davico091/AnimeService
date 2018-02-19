package com.anime.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anime.persist.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer>{

}
