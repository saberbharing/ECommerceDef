package gov.tn.defense.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.tn.defense.entities.Category;
import gov.tn.defense.repositories.CategoryRepository;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/add")
	public Category ajout(@RequestBody Category category)	
	{		
		return categoryRepository.save(category);
	}

}
