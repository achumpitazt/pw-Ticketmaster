package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{
	List<Gender> findByName(String name);
	List<Gender> findByNameStartingWith(String name);
}
