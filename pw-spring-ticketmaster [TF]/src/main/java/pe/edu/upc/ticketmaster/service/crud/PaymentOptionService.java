package pe.edu.upc.ticketmaster.service.crud;

import java.util.List;

import pe.edu.upc.ticketmaster.model.entity.PaymentOption;

public interface PaymentOptionService extends CrudService<PaymentOption, Integer>{
	List<PaymentOption> findByName(String name) throws Exception;
	List<PaymentOption> findByNameStartingWith(String name) throws Exception;
}
