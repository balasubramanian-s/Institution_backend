package com.revature.organization.service;

import java.util.List;

import com.revature.organization.model.Organization;

public interface OrganizationService {

	
	List<Organization> get();
	
	Organization get(int id);
	
	void save(Organization org);
	
	void delete(int id);
}
