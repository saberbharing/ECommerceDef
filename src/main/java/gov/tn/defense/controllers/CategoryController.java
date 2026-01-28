package gov.tn.defense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.tn.defense.entities.Category;
import gov.tn.defense.repositories.CategoryRepository;
import gov.tn.defense.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
		
	@PostMapping("/add")
	public Category ajout(@RequestBody Category category)	
	{		
		return categoryRepository.save(category);
	}	
	
	@GetMapping("/list")
	public List<Category> getAll()
	{
		return categoryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Category getById(@PathVariable int id)
	{
		return categoryRepository.findById(id).get();
	}
	
	@GetMapping("/byname/{nom}")
	public Category getByNom(@PathVariable String name)
	{
		return null;
	}
	
		

	/*@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public List<Category> getAll()
	{
		return categoryService.getAll();
	}*/

}
