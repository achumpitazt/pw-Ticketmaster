package pe.edu.upc.ticketmaster.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.ticketmaster.model.entity.Ticket;
import pe.edu.upc.ticketmaster.model.repository.TicketRepository;
import pe.edu.upc.ticketmaster.service.crud.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public JpaRepository<Ticket, Integer> getRepository() {
		return ticketRepository;
	}

	
	
	

}
