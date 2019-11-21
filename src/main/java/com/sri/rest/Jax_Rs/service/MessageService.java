package com.sri.rest.Jax_Rs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sri.rest.Jax_Rs.model.Message;

public class MessageService {

	public List<Message> getMessageList() {

		List<Message> messageList = new ArrayList();

		messageList.add(new Message(1, "Ta Ta daa!", new Date(), "Sri"));
		messageList.add(new Message(1, "Hakuna Matata!", new Date(), "Sri"));
		messageList.add(new Message(1, "Timon and Pumba", new Date(), "Sri"));

		return messageList;
	}

}
