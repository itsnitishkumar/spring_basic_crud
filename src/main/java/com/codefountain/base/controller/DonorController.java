package com.codefountain.base.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codefountain.base.model.Donor;
import com.codefountain.base.service.DonorService;

@RestController
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@PostMapping("/donor")
	private Donor create(@RequestBody Donor donor){
		return donorService.save(donor);
	}
	
	@PutMapping("/donor/{id}")
	private Donor update(@PathVariable Integer id,@RequestBody Donor donor) {
		Donor don = donorService.findById(id).orElse(null);
		don.setFirstName(donor.getFirstName());
		don.setLastName(donor.getLastName());
		return donorService.save(don);
	}
	
	@GetMapping("/donor")
	private Iterable<Donor> view(){
		return donorService.findAll();
	}
	
	@DeleteMapping("/donor/{id}")
	private void delete(@PathVariable Integer id) {
		donorService.deleteById(id);
	}
}
