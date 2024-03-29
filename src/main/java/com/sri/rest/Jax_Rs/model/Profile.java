package com.sri.rest.Jax_Rs.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private long id;
	private String profileName;
	private String lastName;
	private Date created;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(long id, String profileName, String lastName, Date created) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.lastName = lastName;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", profileName=" + profileName + ", lastName=" + lastName + ", created=" + created
				+ "]";
	}

}
