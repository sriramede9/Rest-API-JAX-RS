package com.sri.rest.Jax_Rs.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sri.rest.Jax_Rs.model.Message;
import com.sri.rest.Jax_Rs.service.MessageService;

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
}
