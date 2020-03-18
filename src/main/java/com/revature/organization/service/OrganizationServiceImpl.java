package com.revature.organization.service;




import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.organization.dao.OrganizationDAO;
import com.revature.organization.dto.IdNameDto;
import com.revature.organization.model.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDAO organizationDAO;

	@Transactional
	@Override
	public List<Organization> get() {
		return organizationDAO.get();
	}

	@Transactional
	@Override
	public Organization get(Long id) {
		return organizationDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Organization org) {
		LocalDateTime ts = LocalDateTime.now();	
		if(org.getId()==null) {		
			org.setIsActive(true);
			 org.setCreatedon(ts);
			}
		else {
			org.setModifiedon(ts);
		}
		organizationDAO.save(org);		 

	}

	@Transactional
	@Override
	public void delete(Long id) {
		organizationDAO.delete(id);

	}
	@Transactional
	@Override
	public void changeStatus(Long id) {
		organizationDAO.changeStatus(id);
		
	}

	@Transactional
	@Override
	public List<Organization> getIdName() {			
	List<Organization> org=new ArrayList<Organization>();
	org=organizationDAO.getIdName();
	
		 return org;
	}

	

}
