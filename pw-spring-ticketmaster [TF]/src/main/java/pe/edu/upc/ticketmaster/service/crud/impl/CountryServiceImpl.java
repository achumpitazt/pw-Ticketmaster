package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.Country;
import pe.edu.upc.ticketmaster.model.repository.CountryRepository;
import pe.edu.upc.ticketmaster.service.crud.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public JpaRepository<Country, Integer> getRepository() {
		return countryRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Country> findByName(String name) throws Exception {
		
		return countryRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Country> findByNameStartingWith(String name) throws Exception {
		
		return countryRepository.findByNameStartingWith(name);
	}

	
}
