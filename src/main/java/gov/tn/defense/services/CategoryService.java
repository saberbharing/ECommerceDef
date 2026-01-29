package gov.tn.defense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.tn.defense.entities.Category;
import gov.tn.defense.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll()
	{
		return categoryRepository.findAll();
	}

}
