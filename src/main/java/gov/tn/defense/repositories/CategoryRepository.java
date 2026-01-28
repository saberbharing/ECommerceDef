package gov.tn.defense.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.tn.defense.entities.Category;
import jakarta.transaction.Transactional;

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
	
	List<Category> findByEditionBefore(Date avant);
	
	List<Category> findByEditionAfter(Date apres);	

	List<Category> findByEditionBetween(Date avant, Date apres);
	
	List<Category> findByNameStartingWithIgnoreCaseAndLotNumberBetweenAndEditionBefore
		(String name, int min, int max, Date edition);
	
	
	//JPQL
	//SQL
	
	@Query("select c from Category c "
			+ " where c.name = :name "
			+ " and c.lotNumber> :lotNumber "
			+ " and c.edition< :edition")
	List<Category> findByMultipleCriteriaJPQL(@Param("name") String name,
			@Param("edition") Date edition, 
			@Param("lotNumber") int min);	
	

	@Query(nativeQuery = true, value = "select * from categories c "
			+ " where c.name Like :name% "
			+ " and c.lot_number> :lotNumber "
			+ " and c.edition< :edition")
	List<Category> findByMultipleCriteriaSQL(@Param("name") String name,
			@Param("edition") Date edition, 
			@Param("lotNumber") int min);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update categories set name=:name where id=:id")
	int updateName(@Param("id") int id, @Param("name") String name);
	
	
	
	
	
	
}
