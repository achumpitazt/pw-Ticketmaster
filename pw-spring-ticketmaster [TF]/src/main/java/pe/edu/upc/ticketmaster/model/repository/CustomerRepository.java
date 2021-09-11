package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/*
	List<Customer> findByName(String name);
	List<Customer> findByNameStartingWith(String name);
	*/
	List<Customer> findByFirstname(String firstname);
	List<Customer> findByFirstnameStartingWith(String firstname);
}
