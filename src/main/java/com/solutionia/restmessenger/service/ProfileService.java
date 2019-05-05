package com.solutionia.restmessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.solutionia.restmessenger.database.DatabaseClass;
import com.solutionia.restmessenger.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		
		profiles.put("EmrulRony", new Profile(1,"EmrulRony","Emrul","Khan"));
		profiles.put("Hasim123", new Profile(2,"Hasim123","Hasim","Amla"));
		
	}
	
	public Profile AddProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public List<Profile> getAllProfiles() {
		
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String profName) {
		
		return profiles.get(profName);
	}
	
	public Profile updateProfile(Profile profile) {
		if (!profile.getProfileName().isEmpty()) {
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		
		return null;
	}
	
	public Profile deleteProfile(String profileName) {
		
		return profiles.remove(profileName);
	}

}
