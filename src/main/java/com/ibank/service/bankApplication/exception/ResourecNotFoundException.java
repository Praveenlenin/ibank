package com.ibank.service.bankApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourecNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourecNotFoundException(String message) {
		super(message);
	}
	
	

}
