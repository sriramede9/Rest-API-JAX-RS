package com.sri.rest.Jax_Rs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sri.rest.Jax_Rs.database.DatabaseClass;
import com.sri.rest.Jax_Rs.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message getMessage(Long l) {
		return messages.get(l);
	}

	public Message addMessage(Message m) {
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}

	public Message updateMessage(Message m) {
		if (m.getId() <= 0) {
			return null;
		}
		messages.put(m.getId(), m);
		return m;
	}

	public Message removeMessage(Message m) {
		return messages.remove(m);
	}

	public List<Message> getMessageList() {

		List<Message> messageList = new ArrayList();

		messages.put(1l, new Message(1, "Ta Ta daa!", new Date(), "Sri"));
		messages.put(2l, new Message(2, "Hakuna Matata!", new Date(), "Sri"));
		// messageList.add(new Message(3, "Timon and Pumba", new Date(), "Sri"));

		return new ArrayList<Message>(messages.values());
	}

}
