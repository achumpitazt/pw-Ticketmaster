package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.Organiser;
import pe.edu.upc.ticketmaster.model.repository.OrganiserRepository;
import pe.edu.upc.ticketmaster.service.crud.OrganiserService;


@Service
public class OrganiserServiceImpl implements OrganiserService{
	
	@Autowired
	private OrganiserRepository organiserRepository;

	@Override
	public JpaRepository<Organiser, Integer> getRepository() {
		return organiserRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Organiser> findByName(String name) throws Exception {
		
		return organiserRepository.findByName(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Organiser> findByNameStartingWith(String name) throws Exception {
		
		return organiserRepository.findByNameStartingWith(name);
	}

	
	

	
}
