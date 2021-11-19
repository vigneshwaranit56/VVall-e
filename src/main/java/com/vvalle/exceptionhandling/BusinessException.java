package com.vvalle.exceptionhandling;

import com.vvalle.dto.Response;
import com.vvalle.dto.Response.StatusEnum;

public class BusinessException extends RuntimeException {
	
	
	private Response response;
	
	public BusinessException(String code, StatusEnum status, String message, String description) {
		super();
		this.response = new Response(code, status, message, description);
	}

	public BusinessException(Response response) {
		super();
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
