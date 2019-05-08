package com.solutionia.restmessenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.solutionia.restmessenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 901, "https://www.google.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
	}

}
