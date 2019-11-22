package com.sri.rest.Jax_Rs.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

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
	 * 
	 */

	MessageService ms = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(@BeanParam MessageFileterBean bean) {

		// System.out.println(year);

		if (bean.getYear() > 0) {

			return ms.getMessagesbyYear(bean.getYear()); // filetering by year if
			// added query param ?year=2018
		}

		if (bean.getStart() > 0 && bean.getSize() > 0) {

			return ms.getAllMessagesPaginated(bean.getStart(), bean.getSize());
		}

		return ms.getMessageList();
	}

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getMessagebyId(@PathParam("id") long id) {

		Message message = ms.getMessage(id);

		return Response.accepted(message).build();

		// return ms.getMessage(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addMessage(Message m, @Context UriInfo uriInfo) {

		Message addMessage = ms.addMessage(m);

//		return Response.status(Status.CREATED)
//			.entity(ms.addMessage(m)).build();

//		return Response.created(new URI("http://localhost:8081/Jax-Rs/webapi/messages/" + addMessage.getId()))
//				.entity(addMessage).build();

		String path = String.valueOf(addMessage.getId());

		URI uri = uriInfo.getAbsolutePathBuilder().path(path).build();

		return Response.created(uri).entity(addMessage).build();

		// return ms.addMessage(m);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateMessage(Message m, @Context UriInfo uriInfo) {

		Message mm = ms.updateMessage(m);

		String path = String.valueOf(mm.getId());

		URI uri = uriInfo.getAbsolutePathBuilder().path(path).build();

		return Response.ok(mm).contentLocation(uri).build();

		// Response.created(uri).entity(mm).build();

		// return ms.updateMessage(m);

	}

	@DELETE
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteMessage(@PathParam("id") long id) {

		// Response.

		Message removeMessage = ms.removeMessage(id);

		return Response.ok(removeMessage).build();

	}

	// @GET
	@Path(value = "/{mId}/comments")
	@Produces(MediaType.APPLICATION_XML)
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
