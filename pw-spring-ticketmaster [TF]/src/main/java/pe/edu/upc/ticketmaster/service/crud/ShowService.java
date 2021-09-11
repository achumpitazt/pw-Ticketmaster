package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.Show;

public interface ShowService extends CrudService<Show, Integer>{
	List<Show> findByName(String name) throws Exception;
	List<Show> findByNameStartingWith(String name) throws Exception;
	

}
