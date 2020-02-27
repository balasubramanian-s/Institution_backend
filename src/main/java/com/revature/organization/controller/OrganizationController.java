

package com.revature.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.organization.model.Organization;
import com.revature.organization.service.OrganizationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("/organization")
	public List<Organization> get() {

		return organizationService.get();

	}

	@PostMapping("/organization")
	public Organization save(@RequestBody Organization organizationObj) {
		organizationService.save(organizationObj);
		return organizationObj;

	}

	@GetMapping("/organization/{id}")
	public Organization get(@PathVariable int id) {
		Organization organizationObj= organizationService.get(id);
		if(organizationObj==null) {
		//	throw new RuntimeException("Employee with "+id+" not found");
		}
		return organizationObj;
	}
	
	@DeleteMapping("/organization/{id}")
	public String delete(@PathVariable int id) {
		organizationService.delete(id);
		return "Employee Deleted with id:"+id;
	}

	@PutMapping("/organization")
	public Organization update(@RequestBody Organization organizationObj) {
		organizationService.save(organizationObj);
		return organizationObj;
	}
	
	
	
	
	
}
