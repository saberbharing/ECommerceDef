package gov.tn.defense.exceptions;

public class CategoryNotFoundException extends RuntimeException {
	
	private int id;
	
	public CategoryNotFoundException(String message)
	{
		super(message);
	}
	
	public CategoryNotFoundException(int id)
	{
		this("La catégorie " + id + " n'existe pas !");
	}

}
