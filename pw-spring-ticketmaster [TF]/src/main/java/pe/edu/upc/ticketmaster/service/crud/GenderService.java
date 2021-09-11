package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.Gender;

public interface GenderService extends CrudService<Gender, Integer>{
	List<Gender> findByName(String name)throws Exception;
	List<Gender> findByNameStartingWith(String name)throws Exception;
}
