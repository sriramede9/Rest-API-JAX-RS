package com.sri.rest.Jax_Rs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link {

	private String link;
	private String rel;

	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Link(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	@Override
	public String toString() {
		return "Link [link=" + link + ", rel=" + rel + "]";
	}

}
