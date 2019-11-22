package com.sri.rest.Jax_Rs.resources;

import java.net.URI;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("con")
public class TypesOfParam {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAttribute(@MatrixParam("m") String s, @CookieParam("name") String cooki,
			@HeaderParam("why") String h) {

		return "Hei" + "matrix param here " + s + "Cookie param \t" + cooki + "\t" + h;
	}

	@GET
	@Path(value = "context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getcontext(@Context UriInfo uriInfo) {

		URI absolutePath = uriInfo.getAbsolutePath();
		
		//absolutePath.
		return absolutePath.toString();
	}
}
