package com.tiffany.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiffany.languages.models.Language;
import com.tiffany.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
//	@RequestMapping("/languages/new")
//    public String newLanguage(@ModelAttribute("language") Language language) {
//        return "/languages/index.jsp";
//    }
    
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    // @Valid annotation to check to see if the submitted object passes validation.
    // inject the BindingResult to see if the object passed validation. This MUST come immediately after the @Valid parameter.
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        	// creation form is on the main page
            return "/languages/index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    // Show specific language info
    @RequestMapping(value="/languages/{id}")
    public String showLanguageInfo(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("language", languageService.findLanguage(id));
    	return "/languages/showInfo.jsp";
    }
    
    // Edit a specific language
    @RequestMapping(value="/languages/{id}/edit")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    // Update a specific language
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    // Delete language
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
