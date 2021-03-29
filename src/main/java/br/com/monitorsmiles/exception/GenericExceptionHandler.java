package br.com.monitorsmiles.exception;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { PlaceNotExistException.class })
	protected ResponseEntity<Object> placeNotFound(RuntimeException exception, WebRequest request) {
		return handle("Place not exists", NOT_FOUND ,exception, request);
	}
	
	@ExceptionHandler(value = { PlaceAlreadyExistisException.class })
	protected ResponseEntity<Object> placeAlreadyExistis(RuntimeException exception, WebRequest request) {
		return handle("Place Already exists",CONFLICT, exception, request);
	}
	
	@ExceptionHandler(value = { Throwable.class })
	protected ResponseEntity<Object> generic(RuntimeException exception, WebRequest request) {
		return handle(";( Sorry Somethings goes wrong ",HttpStatus.INTERNAL_SERVER_ERROR, exception, request);
	}

	private ResponseEntity<Object> handle(String message,HttpStatus status, RuntimeException exception, WebRequest request) {
		return handleExceptionInternal(exception, message, new HttpHeaders(), status, request);
	}

}
