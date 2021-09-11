package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.Customer;

public interface CustomerService extends CrudService<Customer, Integer>{
	/*
	List<Customer> findByName(String firstName) throws Exception;
	List<Customer> findByNameStartingWith(String firstName) throws Exception;
	*/
	List<Customer> findByFirstname(String firstname) throws Exception;
	List<Customer> findByFirstnameStartingWith(String firstname) throws Exception;
}
