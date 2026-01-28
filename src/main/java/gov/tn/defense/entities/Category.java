package gov.tn.defense.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String name;
	private int lotNumber;
	
	@Temporal(TemporalType.DATE)
	private Date edition;
		
	public Date getEdition() {
		return edition;
	}
	public void setEdition(Date edition) {
		this.edition = edition;
	}
	public Category(int id, String name, int lotNumber, Date edition) {
		super();
		this.id = id;
		this.name = name;
		this.lotNumber = lotNumber;
		this.edition = edition;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String name, int lotNumber) {
		super();
		this.id = id;
		this.name = name;
		this.lotNumber = lotNumber;
	}
	public Category(String name, int lotNumber) {
		super();
		this.name = name;
		this.lotNumber = lotNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(int lotNumber) {
		this.lotNumber = lotNumber;
	}

	
	
}
