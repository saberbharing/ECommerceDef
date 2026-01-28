package gov.tn.defense.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity 
@Table(name = "products") 
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(precision = 3)
	private double price;
	
	@Temporal(TemporalType.DATE)
	private Date dlc;

	public Product(String name, double price, Date dlc) {
		super();
		this.name = name;
		this.price = price;
		this.dlc = dlc;
	}

	public Product(int id, String name, double price, Date dlc) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dlc = dlc;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDlc() {
		return dlc;
	}

	public void setDlc(Date dlc) {
		this.dlc = dlc;
	}

}
