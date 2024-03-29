package com.sri.rest.Jax_Rs.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sri.rest.Jax_Rs.database.DatabaseClass;
import com.sri.rest.Jax_Rs.model.Comment;
import com.sri.rest.Jax_Rs.model.ErrorMessage;
import com.sri.rest.Jax_Rs.model.Message;
import com.sri.rest.Jax_Rs.model.Comment;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public CommentService() {
		super();
		// TODO Auto-generated constructor stub
//		comments.put(1l, new Comment(1, "cool comment!", new Date(), "Sri Ram"));
//		comments.put(2l, new Comment(2, "hard comment!", new Date(), "Sri Ede"));
//		comments.put(3l, new Comment(3, "Time pass", new Date(), "Sri Ram"));
//		 Map<Long, Comment> comments = messages.get(1).getComments();
//
//		 comments.put(1l, new Comment(1l, "comment", new Date(), "Sri"));

	}

	public List<Comment> getAllComments(Long l) {

		Map<Long, Comment> comments = messages.get(l).getComments();

		return new ArrayList<Comment>(comments.values());
	}

	public Comment getCommentById(Long messageId, Long commentid) {

		// bilding a response object for webapplicationexception

		ErrorMessage em = new ErrorMessage("No such object", 404, "The given id is not in the database to fetch");

		// Response.noContent().entity(em).build();
		Response response = Response.status(Status.NOT_FOUND).entity(em).build();

		Message message = messages.get(messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		// System.out.println(comments);

		Comment comment = comments.get(commentid);

		if (comment == null) {
			throw new WebApplicationException(response);
		}

		return comments.get(commentid);
	}

	public Comment addComment(Long messageId, Comment comment) {

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(), comment);

		System.out.println(comments);
		return comment;
	}

	public Comment updateComment(Long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		System.out.println(comments);

		return comment;
	}

	public Comment removeComment(long messageId, Long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

}
