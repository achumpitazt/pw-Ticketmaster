package pe.edu.upc.ticketmaster.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.ticketmaster.model.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
