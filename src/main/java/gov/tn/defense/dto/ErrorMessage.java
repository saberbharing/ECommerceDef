package gov.tn.defense.dto;

import java.time.LocalDate;

public class ErrorMessage {
	private String message;
	private LocalDate timestamp; 
	private int status;
	private String description;
	
	public ErrorMessage(String message, LocalDate timestamp, int status, String description) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		this.description = description;
	}
	

}
