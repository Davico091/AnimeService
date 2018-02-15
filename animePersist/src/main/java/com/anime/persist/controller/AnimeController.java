package com.anime.persist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anime.persist.model.Anime;
import com.anime.persist.repository.AnimeRepository;

@RestController
public class AnimeController {

	@Autowired
	AnimeRepository animeRepository;
	
	@GetMapping("/animes")
	public List<Anime> getAllNotes() {
	    return animeRepository.findAll();
	}
	
	@PostMapping("/notes")
	public Anime createAnime(@RequestBody Anime anime) {
		return animeRepository.save(anime);
	}
	
	@GetMapping("/animes/{id}")
	public ResponseEntity<Anime> getAnimeById(@PathVariable(value = "id") int animeId) {
	    Anime anime = animeRepository.findOne(animeId);
	    if(anime == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(anime);
	}
	
	@PutMapping("/animes/{id}")
	public ResponseEntity<Anime> updateAnime(@PathVariable(value = "id") int animeId, @RequestBody Anime animeRq) {
	    Anime anime = animeRepository.findOne(animeId);
	    if(anime == null) {
	        return ResponseEntity.notFound().build();
	    }
	    anime.setName(animeRq.getName());
	    
	    Anime updatedAnime = animeRepository.save(anime);
	    return ResponseEntity.ok(updatedAnime);
	}
	
	@DeleteMapping("/animes/{id}")
	public ResponseEntity<Anime> deleteAnime(@PathVariable(value = "id") int animeId) {
	    Anime anime = animeRepository.findOne(animeId);
	    if(anime == null) {
	        return ResponseEntity.notFound().build();
	    }

	    animeRepository.delete(anime);
	    return ResponseEntity.ok().build();
	}
}
