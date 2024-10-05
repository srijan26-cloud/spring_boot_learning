package com.chapter_5.third.party.rest.API.Advices;


import com.chapter_5.third.party.rest.API.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException ex)
	{
		ApiError apiError = ApiError.builder()
				.status(HttpStatus.NOT_FOUND)
				.message(ex.getMessage())
				.build();
		return buildErrorResponseEntity(apiError);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException ex)
	{
		List<String> errors = ex
				.getBindingResult()
				.getAllErrors()
				.stream()
				.map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		
		ApiError apiError = ApiError.builder()
				.status(HttpStatus.BAD_REQUEST)
				.message("Input Validation Failed")
				.subErrors(errors)
				.build();
		
		return buildErrorResponseEntity(apiError);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse<?>> handleServerError(RuntimeException ex)
	{
		ApiError apiError = ApiError.builder()
				.status(HttpStatus.SERVICE_UNAVAILABLE)
				.message(ex.getMessage())
				.build();
		return buildErrorResponseEntity(apiError);
	}
	
	private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(new ApiResponse<>(apiError) ,apiError.getStatus());
	}
	
}
