package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.Organiser;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser, Integer>{
	
	List<Organiser> findByName(String name);
	List<Organiser> findByNameStartingWith(String name);
}
