package gov.tn.defense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import gov.tn.defense.entities.Category;
import gov.tn.defense.producers.CategoryEventProducer;
import gov.tn.defense.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryEventProducer categoryEventProducer;
	
	public List<Category> getAll()
	{
		return categoryRepository.findAll();
	}	

	public Category ajout(Category category) {
		
		Category catAjoute=categoryRepository.save(category);
		
		categoryEventProducer.sendKafkaEvent(catAjoute.getId());
		
		return catAjoute;
	}

}
