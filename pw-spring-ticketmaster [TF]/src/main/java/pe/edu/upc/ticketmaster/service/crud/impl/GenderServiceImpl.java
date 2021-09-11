package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.Gender;
import pe.edu.upc.ticketmaster.model.repository.GenderRepository;
import pe.edu.upc.ticketmaster.service.crud.GenderService;

@Service
public class GenderServiceImpl implements GenderService{
	
	@Autowired
	private GenderRepository genderRepository;

	@Override
	public JpaRepository<Gender, Integer> getRepository() {
		return genderRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gender> findByName(String name) throws Exception {
		
		return genderRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gender> findByNameStartingWith(String name) throws Exception {
		
		return genderRepository.findByNameStartingWith(name);
	}

	
	
	

}
