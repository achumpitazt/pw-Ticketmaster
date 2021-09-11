package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.EventType;
import pe.edu.upc.ticketmaster.model.repository.EventTypeRepository;
import pe.edu.upc.ticketmaster.service.crud.EventTypeService;


@Service
public class EventTypeServiceImpl implements EventTypeService{

	@Autowired
	private EventTypeRepository eventTypeRepository;

	@Override
	public JpaRepository<EventType, Integer> getRepository() {
		return eventTypeRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<EventType> findByName(String name) throws Exception {
		
		return eventTypeRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<EventType> findByNameStartingWith(String name) throws Exception {
		
		return eventTypeRepository.findByNameStartingWith(name);
	}

	

	
}
