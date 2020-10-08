package com.assignment.nelson.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assigment.nelson.languages.repositories.LanguageRepository;
import com.assignment.nelson.languages.models.Language;

@Service
public class LanguageService {
	private final LanguageRepository repo;
	
	public LanguageService(LanguageRepository repo) {
		this.repo = repo;
	}
	
	// returns all the languages
	public List<Language> allLanguages() {
		return repo.findAll();
	}
	// creates a language
	public Language createLanguage(Language l) {
		return repo.save(l);
	}
	// retrieves a language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = repo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	//update language
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Language> optionalLanguage = repo.findById(id);
		if(optionalLanguage != null) {
			optionalLanguage.get().setName(name);
			optionalLanguage.get().setCreator(creator);
			optionalLanguage.get().setCurrentVersion(currentVersion);
			
			return optionalLanguage.get();
		}
		return null;
	}
	
	public void deleteLanguage(Long id) {
		repo.deleteById(id);
	}
}
