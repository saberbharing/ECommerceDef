package gov.tn.defense.advices;

import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import gov.tn.defense.dto.ErrorMessage;
import gov.tn.defense.exceptions.CategoryNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//RTE
	//RNFE
	
	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<ErrorMessage> handleRuntimeException
		(RuntimeException ex, WebRequest request )
	{
		ErrorMessage em = new ErrorMessage("Une erreur de calcul !", 
				LocalDate.now(), 
				550, 
				ex.getMessage());			
		
		return new ResponseEntity<>(em, HttpStatus.valueOf(550));
	}
	
	@ExceptionHandler(exception = CategoryNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleRNFException
		(CategoryNotFoundException  ex, WebRequest request )
	{
		ErrorMessage em = new ErrorMessage("La catégorie n'existe pas!", 
				LocalDate.now(), 
				404, 
				ex.getMessage());			
		
		return new ResponseEntity<>(em, HttpStatus.valueOf(404));
	}	

	@ExceptionHandler(exception = SQLException.class)
	public ResponseEntity handleSQLxception
		(SQLException  ex, WebRequest request )
	{		
		
		return new ResponseEntity(HttpStatus.valueOf(512));
	}
	
	
	

}
