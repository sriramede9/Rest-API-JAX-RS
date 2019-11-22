package com.sri.rest.Jax_Rs.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.sri.rest.Jax_Rs.database.DatabaseClass;
import com.sri.rest.Jax_Rs.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		super();
		// TODO Auto-generated constructor stub
		messages.put(1l, new Message(1, "Ta Ta daa!", new Date(), "Sri"));
		messages.put(2l, new Message(2, "Hakuna Matata!", new Date(), "Sri"));
		messages.put(3l, new Message(3, "Timon and Pumba", new Date(), "Sri"));
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

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

	public List<Message> getMessageList() {

		return new ArrayList<Message>(messages.values());
	}

	// pagination concept

	public List<Message> getMessagesbyYear(int year) {

		ArrayList<Message> arrayList = new ArrayList<Message>(messages.values());

		List<Message> fileteredList = new ArrayList<Message>();

		for (Message m : arrayList) {

			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			String ss = format.format(m.getCreated());
			if (ss.equals(String.valueOf(year))) {
				// System.out.println("adding these to a new list");
				fileteredList.add(m);
			}
		}

		return fileteredList;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {

		List<Message> temp = new ArrayList<>();

		for (int i = start; i < start + size; i++) {

			try {
				temp.add(getMessageList().get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		//System.out.println(
			//	"vaues in temp are from " + temp.get(0).getId() + "/t and total of them are " + temp.size() + temp);

		return temp;
	}

}
