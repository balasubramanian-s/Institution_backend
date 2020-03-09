package com.revature.organization.dao;

import java.util.List;

import com.revature.organization.model.Organization;

public interface OrganizationDAO {
	
	List<Organization> get();
	
	Organization get(Long id);
	
	void save(Organization org);
	
	void delete(Long id);

	
}
