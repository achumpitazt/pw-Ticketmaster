package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{
	List<Show> findByName(String name);
	List<Show> findByNameStartingWith(String name);
	
	// JPQL
	//@Query("select s from Show s inner join Organiser o ON s.organiser_id = o.organiser_id WHERE UPPER(o.name) LIKE CONCAT(UPPER(:name),'%') ")
	//List<Show> findByOrganiserName(String name);
}
