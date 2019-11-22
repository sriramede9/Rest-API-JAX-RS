package com.sri.rest.Jax_Rs.resources;

import java.util.ArrayList;
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
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sri.rest.Jax_Rs.model.Comment;
import com.sri.rest.Jax_Rs.model.Message;
import com.sri.rest.Jax_Rs.service.CommentService;
import com.sri.rest.Jax_Rs.service.MessageService;

@Path(value = "/")
@XmlRootElement
public class CommentResource {

	CommentService cs = new CommentService();

	public CommentResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Comment> GetALLcomments(@PathParam("mId") long messageId) {

		return cs.getAllComments(messageId);
	}

	@GET
	@Path(value = "{cId}")
	@Produces(MediaType.APPLICATION_XML)
	public Comment GetcommentsbyId(@PathParam("mId") long mid, @PathParam("cId") long cid) {

		System.out.println(mid + "" + cid);

		Comment commentById = cs.getCommentById(mid, cid);

		System.out.println(commentById + "this is what i got");

		return commentById;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Comment addCommenttoMessage(@PathParam("mId") long messageId, Comment comment) {

		System.out.println(messageId + "" + comment);

		return cs.addComment(messageId, comment);
	}

	@PUT
	@Path(value = "/{commentId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Comment updateMessage(@PathParam("mid") long messageId, @PathParam("commentId") int cid, Comment comment) {

		comment.setId(cid);

		return cs.updateComment(messageId, comment);

	}

	@DELETE
	@Path(value = "{commentId}")
	@Produces(MediaType.APPLICATION_XML)
	public Comment deleteMessage(@PathParam("mid") long messageId, @PathParam("commentId") long cid) {

		return cs.removeComment(messageId, cid);

	}

}
