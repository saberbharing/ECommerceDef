package gov.tn.defense.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.tn.defense.entities.Category;
import gov.tn.defense.exceptions.CategoryNotFoundException;
import gov.tn.defense.repositories.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("/add")
	public Category ajout(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/list")
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public Category getById(@PathVariable int id) {
		return categoryRepository.findById(id).get();
	}

	@GetMapping("/byname/{nom}")
	public List<Category> getByNom(@PathVariable String name) {
		return categoryRepository.findByName(name);
	}

	@PutMapping("/maj/{id}")
	public ResponseEntity<Category> majCatgory(@PathVariable int id, @RequestBody Category cat) {

		Optional<Category> catModifie = categoryRepository.findById(id);
		// .orElseThrow(()->new CategoryNotFoundException(id));

		if (catModifie.isPresent()) {
			Category mod = catModifie.get();
			mod.setName(cat.getName());
			mod.setLotNumber(cat.getLotNumber());
			mod.setEdition(cat.getEdition());

			return new ResponseEntity<>(categoryRepository.save(mod), HttpStatus.OK) ;
		}
		else
		{
			return new ResponseEntity<>(HttpStatusCode.valueOf(440));
		}
	}

	@PutMapping("/update")
	public Category majCategoryEnity(@RequestBody Category cat) {
		return categoryRepository.save(cat);
	}

	@PutMapping("/majname/{id}/{name}")
	public int majCategoryName(@PathVariable int id, @PathVariable String name) {
		return categoryRepository.updateName(id, name);
	}

	/*
	 * @Autowired private CategoryService categoryService;
	 * 
	 * @GetMapping("/list") public List<Category> getAll() { return
	 * categoryService.getAll(); }
	 */

}
