package pe.edu.upc.ticketmaster.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ticketmaster.model.entity.PaymentOption;

@Repository
public interface PaymentOptionRepository extends JpaRepository<PaymentOption, Integer>{
	List<PaymentOption> findByName(String name);
	List<PaymentOption> findByNameStartingWith(String name);
}
