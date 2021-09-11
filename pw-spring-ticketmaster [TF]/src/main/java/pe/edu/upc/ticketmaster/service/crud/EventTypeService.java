package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.EventType;

public interface EventTypeService extends CrudService<EventType, Integer>{
	
	List<EventType> findByName(String name) throws Exception;
	List<EventType> findByNameStartingWith(String name) throws Exception;
	
}
