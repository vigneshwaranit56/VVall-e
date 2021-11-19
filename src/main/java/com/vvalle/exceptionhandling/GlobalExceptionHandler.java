package com.vvalle.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vvalle.dto.Response;
import com.vvalle.dto.Response.StatusEnum;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> businessException(HttpServletRequest request, BusinessException ex) {
        return new ResponseEntity<Response>(ex.getResponse(), HttpStatus.CONFLICT);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response> genralException(HttpServletRequest request, Exception ex) {
        return new ResponseEntity<Response>(new Response("ERR00031", StatusEnum.ERROR, ex.getLocalizedMessage(),ex.getStackTrace()),HttpStatus.BAD_REQUEST);
    }

	@Override
     protected ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

         return new ResponseEntity<>(new Response("ERR00033", StatusEnum.ERROR, ex.getLocalizedMessage(),ex.getStackTrace()), HttpStatus.CONFLICT);
     }
}
