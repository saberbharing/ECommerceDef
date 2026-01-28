package gov.tn.defense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.tn.defense.entities.Category;
import gov.tn.defense.repositories.CategoryRepository;

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
	public List<Category> getByNom(@PathVariable String name)
	{
		return categoryRepository.findByName(name);
	}
	
	
	@PutMapping("/maj/{id}")
	public Category majCatgory(@PathVariable int id, @RequestBody Category cat)
	{
		Category catModifie= categoryRepository.findById(id)
				.orElseThrow(()->new RuntimeException());

		catModifie.setName(cat.getName());
		catModifie.setLotNumber(cat.getLotNumber());
		catModifie.setEdition(cat.getEdition());
		
		return categoryRepository.save(catModifie);
	}
		
	@PutMapping("/update")
	public Category majCategoryEnity(@RequestBody Category cat)
	{		
		return categoryRepository.save(cat);
	}
	
	@PutMapping("/majname/{id}/{name}")
	public int majCategoryName(@PathVariable int id, @PathVariable String name)
	{				
		return categoryRepository.updateName(id, name);
	}
		

	/*@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public List<Category> getAll()
	{
		return categoryService.getAll();
	}*/

}
