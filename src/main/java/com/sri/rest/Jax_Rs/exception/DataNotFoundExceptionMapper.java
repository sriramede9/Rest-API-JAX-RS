package com.sri.rest.Jax_Rs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sri.rest.Jax_Rs.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<MessageNotFoundException> {

	@Override
	public Response toResponse(MessageNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage em = new ErrorMessage(exception.getMessage(), 404, "The given id is not in the database to fetch");

		// Response.noContent().entity(em).build();
		return Response.status(Status.NOT_FOUND).entity(em).build();

	}

}
