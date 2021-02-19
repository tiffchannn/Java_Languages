package com.tiffany.languages.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiffany.languages.models.Language;

// This is where we gain access to all our data once we start talking with the database

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	// find all languages
	List<Language> findAll();
	
	// find language by details
	List<Language> findByCurrentVersion(String search);
	
	Long deleteByNameStartingWith(String search);
}
