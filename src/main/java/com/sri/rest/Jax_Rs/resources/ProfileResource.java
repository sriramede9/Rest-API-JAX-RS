package com.sri.rest.Jax_Rs.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sri.rest.Jax_Rs.model.Profile;
import com.sri.rest.Jax_Rs.service.ProfileService;

@Path("profiles")
public class ProfileResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getProfiles() {

		return new ProfileService().getProfileList();
	}

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Profile getProfilebyId(@PathParam("id") long l) {

		return new ProfileService().getProfile(l);
	}

}
