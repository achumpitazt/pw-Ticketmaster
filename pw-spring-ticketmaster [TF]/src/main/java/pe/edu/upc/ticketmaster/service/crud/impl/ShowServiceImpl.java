package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.model.repository.ShowRepository;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private ShowRepository showRepository;

	@Override
	public JpaRepository<Show, Integer> getRepository() {
		// TODO Auto-generated method stub
		return showRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Show> findByName(String name) throws Exception {
		
		return showRepository.findByName(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Show> findByNameStartingWith(String name) throws Exception {
		
		return showRepository.findByNameStartingWith(name);
	}

	

	
}
