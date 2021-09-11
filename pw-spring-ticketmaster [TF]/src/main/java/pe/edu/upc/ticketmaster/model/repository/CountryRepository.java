package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	List<Country> findByName(String name);
	List<Country> findByNameStartingWith(String name);
}
