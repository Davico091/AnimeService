package com.anime.persist.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anime.persist.model.Anime;
import com.anime.persist.model.Hero;
import com.anime.persist.repository.HeroRepository;
import com.google.gson.Gson;
@CrossOrigin(origins = "*")
@RestController
public class HeroController {
	
	@Autowired
	HeroRepository heroRepository;
	
    private static final Logger LOGGER = LogManager.getLogger(HeroController.class);
    private Gson gson= new Gson();
	
	@GetMapping("/heroes")
	public List<Hero> getAllNotes() {
	    return heroRepository.findAll();
	}
	
	@GetMapping("/heroes/name/{name}")
	public List<Hero> getAllNotesByName(@PathVariable String name) {
	    return heroRepository.findByName(name);
	}
	
	@PostMapping("/heroes")
	public Hero createHero(@RequestBody Hero hero) {
		LOGGER.info("error**************");
		LOGGER.info(hero.toString());
		return heroRepository.save(hero);
	}
	
	@GetMapping("/heroes/{id}")
	public ResponseEntity<Hero> getHeroById(@PathVariable(value = "id") int heroId) {
	    Hero hero = heroRepository.findOne(heroId);
	    if(hero == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(hero);
	}
	
	@GetMapping("/heroes2/")
	public List<Hero> getHeroByName(@RequestParam(value = "name") String name) {

	    return heroRepository.findAll();
	}
	
	@PutMapping("/heroes/{id}")
	public ResponseEntity<Hero> updateHero(@PathVariable(value = "id") int heroId, @RequestBody Hero heroRq) {
	    Hero hero = heroRepository.findOne(heroId);
	    if(hero == null) {
	        return ResponseEntity.notFound().build();
	    }
	    hero.setName(heroRq.getName());
	    
	    Hero updatedHero = heroRepository.save(hero);
	    return ResponseEntity.ok(updatedHero);
	}
	
	@DeleteMapping("/heroes/{id}")
	public ResponseEntity<Hero> deleteHero(@PathVariable(value = "id") int heroId) {
	    Hero hero = heroRepository.findOne(heroId);
	    if(hero == null) {
	        return ResponseEntity.notFound().build();
	    }

	    heroRepository.delete(hero);
	    return ResponseEntity.ok().build();
	}
}
