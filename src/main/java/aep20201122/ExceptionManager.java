package aep20201122;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionManager {

	    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
	    public ResponseEntity<Void> handleNotFound() {
	        return ResponseEntity.notFound().build();
	    }

	    @ExceptionHandler(RegistroExistente.class)
	    public ResponseEntity<Void> handleConflict() {
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    }

	    @ExceptionHandler(IdsDiferentes.class)
	    public ResponseEntity<Void> handleBadRequest() {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }

	    
}
