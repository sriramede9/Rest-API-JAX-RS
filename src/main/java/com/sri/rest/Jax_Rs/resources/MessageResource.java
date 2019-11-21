package com.sri.rest.Jax_Rs.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sri.rest.Jax_Rs.model.Message;
import com.sri.rest.Jax_Rs.model.Profile;
import com.sri.rest.Jax_Rs.service.MessageService;
import com.sri.rest.Jax_Rs.service.ProfileService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("messages")
public class MessageResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return new MessageService().getMessageList();
	}

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessagebyId(@PathParam("id") long id) {

		return new MessageService().getMessage(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message m) {
		return new MessageService().addMessage(m);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(Message m) {

		return new MessageService().updateMessage(m);

	}

	@DELETE
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Message deleteMessage(@PathParam("id") long id) {

		return new MessageService().removeMessage(id);

	}

}
