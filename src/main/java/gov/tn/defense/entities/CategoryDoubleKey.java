package gov.tn.defense.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name="categories")
public class CategoryDoubleKey {

	//@EmbeddedId
	private CategoryId id;
	
	private String name;
	
}
