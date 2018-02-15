package com.anime.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anime.persist.model.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer>{

}
