package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.repository.CustomerRepository;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public JpaRepository<Customer, Integer> getRepository() {
		// TODO Auto-generated method stub
		return customerRepository;
	}
	/*
	@Transactional(readOnly = true)
	@Override
	public List<Customer> findByName(String firstName) throws Exception {
		
		return customerRepository.findByName(firstName);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> findByNameStartingWith(String firstName) throws Exception {
		return customerRepository.findByNameStartingWith(firstName);
	}

	*/
	@Transactional(readOnly = true)
	@Override
	public List<Customer> findByFirstname(String firstname) throws Exception {
		return customerRepository.findByFirstname(firstname);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Customer> findByFirstnameStartingWith(String firstname) throws Exception {
		return customerRepository.findByFirstnameStartingWith(firstname);
	}

	

}
