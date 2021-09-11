package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.Country;

public interface CountryService extends CrudService<Country, Integer>{
	List<Country> findByName(String name) throws Exception;
	List<Country> findByNameStartingWith(String name) throws Exception;
}
