package gov.tn.defense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.tn.defense.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	List<Category> findByName (String name);
	
	//Like %?%	
	List<Category> findByNameContaining (String name);

	//Like ?%
	List<Category> findByNameStartingWith (String name);
	
	//Like %?
	List<Category> findByNameEndingWith (String name);
	
	List<Category> findByLotNumber(int number);	

	List<Category> findByLotNumberGreaterThan(int number);	

	List<Category> findByLotNumberLessThan(int number);	

	List<Category> findByLotNumberBetween(int min, int max);

	List<Category> findByNameStartingWithAndLotNumberGreaterThan (String name, int number);
	
}
