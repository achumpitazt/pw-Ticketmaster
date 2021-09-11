package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer>{
	
	List<EventType> findByName(String name);
	List<EventType> findByNameStartingWith(String name);

}
