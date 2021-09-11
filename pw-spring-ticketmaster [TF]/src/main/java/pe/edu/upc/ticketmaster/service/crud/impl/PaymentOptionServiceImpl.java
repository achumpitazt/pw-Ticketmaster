package pe.edu.upc.ticketmaster.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ticketmaster.model.entity.PaymentOption;
import pe.edu.upc.ticketmaster.model.repository.PaymentOptionRepository;
import pe.edu.upc.ticketmaster.service.crud.PaymentOptionService;

@Service
public class PaymentOptionServiceImpl implements PaymentOptionService{
	
	@Autowired
	private PaymentOptionRepository paymentOptionRepository;

	@Override
	public JpaRepository<PaymentOption, Integer> getRepository() {
		return paymentOptionRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<PaymentOption> findByName(String name) throws Exception {
		
		return paymentOptionRepository.findByName(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PaymentOption> findByNameStartingWith(String name) throws Exception {
		
		return paymentOptionRepository.findByNameStartingWith(name);
	}

			

}
