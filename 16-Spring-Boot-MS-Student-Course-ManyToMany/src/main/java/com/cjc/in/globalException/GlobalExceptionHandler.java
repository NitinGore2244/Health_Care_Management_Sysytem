package com.cjc.in.globalException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cjc.in.exception.CourseIDNotFound;
import com.cjc.in.exception.CourseIDNotMatch;
import com.cjc.in.exception.CourseNotFound;
import com.cjc.in.exception.StudentIdNotMatch;
import com.cjc.in.exception.StudentNotFound;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(CourseIDNotMatch.class)
	public ResponseEntity<String> courseID()
	{
		return new ResponseEntity<String>("Course ID Not Corrected",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(StudentIdNotMatch.class)
	public ResponseEntity<String> stuID()
	{
		return new ResponseEntity<String>("Student ID Not Corrected",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<String> studentNotFound()
	{
		return new ResponseEntity<String>("Student Not Found",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CourseNotFound.class)
	public ResponseEntity<String> courseNotFound()
	{
		return new ResponseEntity<String>("Course Not Found",HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(CourseIDNotFound.class)
	public ResponseEntity<String> courseIdNotFound()
	{
		return new ResponseEntity<String>("Course ID Not Found",HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Method Not Supported",HttpStatus.BAD_REQUEST);
	}
}
