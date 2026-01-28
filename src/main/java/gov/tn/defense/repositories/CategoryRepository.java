package gov.tn.defense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.tn.defense.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
