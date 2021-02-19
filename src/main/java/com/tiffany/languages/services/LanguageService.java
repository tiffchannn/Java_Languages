package com.tiffany.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tiffany.languages.models.Language;
import com.tiffany.languages.repos.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	// find all languages
	public List<Language> allLanguages() {
        return languageRepo.findAll();
    }
	
    // creates a language
    public Language createLanguage(Language language) {
        return languageRepo.save(language);
    }
    
    // retrieves a language by ID
    public Language findLanguage(Long id) {
        Optional<Language> language = languageRepo.findById(id);
        if(language.isPresent()) {
            return language.get();
        } else {
            return null;
        }
    }
    
    // update language details
//    public void updateLanguage(Long id, String name, String currentVersion, String creator) {
////    	Language updateLanguage = languageRepo.findById(language.getId());
//    	Language updateLanguage = findLanguage(id);
//    	updateLanguage.setName(name);
//    	updateLanguage.setCurrentVersion(currentVersion);
//    	updateLanguage.setCreator(creator);
//    	languageRepo.save(updateLanguage);
//    }
    
    public Language updateLanguage(Language language) {
    	return languageRepo.save(language);
    }
    
    // delete language based on the ID
    public void deleteLanguage(Long id) {
    	languageRepo.deleteById(id);
    }
    
}
