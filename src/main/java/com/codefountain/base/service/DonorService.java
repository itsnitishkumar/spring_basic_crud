package com.codefountain.base.service;

import org.springframework.data.repository.CrudRepository;

import com.codefountain.base.model.Donor;

public interface DonorService extends CrudRepository<Donor, Integer>{

}
