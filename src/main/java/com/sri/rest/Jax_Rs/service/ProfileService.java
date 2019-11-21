package com.sri.rest.Jax_Rs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sri.rest.Jax_Rs.database.DatabaseClass;
import com.sri.rest.Jax_Rs.model.Message;
import com.sri.rest.Jax_Rs.model.Profile;

public class ProfileService {

	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		super();
		// TODO Auto-generated constructor stub
		// profiles.put(1l, new Profile(1, "Jai", "Sri", new Date()));
//		profiles.put(2l, new Profile(2, "Veo", "Ede", new Date()));
	}

	public Profile getProfile(Long l) {
		return profiles.get(l);
	}

	public Profile addProfile(Profile p) {
		p.setId(profiles.size() + 1);
		profiles.put(p.getId(), p);
		return p;
	}

	public Profile updateProfile(Profile p) {
		if (p.getId() <= 0) {
			return null;
		}
		profiles.put(p.getId(), p);
		return p;
	}

	public Profile removeProfile(Long id) {
		return profiles.remove(id);
	}

	public List<Profile> getProfileList() {

		return new ArrayList<Profile>(profiles.values());
	}

}
