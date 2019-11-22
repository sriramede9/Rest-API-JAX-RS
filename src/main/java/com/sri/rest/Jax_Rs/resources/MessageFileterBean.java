package com.sri.rest.Jax_Rs.resources;

import javax.ws.rs.QueryParam;

public class MessageFileterBean {

	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public MessageFileterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageFileterBean(int year, int start, int size) {
		super();
		this.year = year;
		this.start = start;
		this.size = size;
	}
	
	
	
}
