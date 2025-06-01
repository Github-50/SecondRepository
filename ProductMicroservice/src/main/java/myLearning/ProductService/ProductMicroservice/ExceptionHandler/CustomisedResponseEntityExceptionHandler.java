package myLearning.ProductService.ProductMicroservice.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import myLearning.ProductService.ProductMicroservice.Error.ErrorDetails;
import myLearning.ProductService.ProductMicroservice.Exception.NoRecordsFoundException;


@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	//for 400 - BAD_REQUEST
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails err = new ErrorDetails(ex.getMessage()+" #IN EXCEPTIONHANDLER 400 BAD_REQUEST#", request.getDescription(false),
				LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	//for 404 - NOT_FOUND
	@ExceptionHandler(NoRecordsFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFoundException(NoRecordsFoundException ex, 
			WebRequest req) {
		ErrorDetails err = new ErrorDetails(ex.getMessage()+" #IN EXCEPTIONHANDLER 404 NOT_FOUND#", req.getDescription(false), 
				LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	//for 500 - INTERNAL_SERVER_ERROR
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest req) {
		ErrorDetails err = new ErrorDetails(ex.getMessage()+" #IN EXCEPTIONHANDLER 500 INTERNAL_SERVER_ERROR", req.getDescription(false), 
				LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
