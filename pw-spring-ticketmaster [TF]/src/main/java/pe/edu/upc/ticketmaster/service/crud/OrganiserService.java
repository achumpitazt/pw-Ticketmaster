package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.Organiser;

public interface OrganiserService extends CrudService<Organiser, Integer> {
	
	List<Organiser> findByName(String name) throws Exception;
	List<Organiser> findByNameStartingWith(String name) throws Exception;
}
