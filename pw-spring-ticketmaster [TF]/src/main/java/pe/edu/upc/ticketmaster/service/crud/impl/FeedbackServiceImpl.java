package pe.edu.upc.ticketmaster.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import pe.edu.upc.ticketmaster.model.entity.Feedback;
import pe.edu.upc.ticketmaster.model.repository.FeedbackRepository;
import pe.edu.upc.ticketmaster.service.crud.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public JpaRepository<Feedback, Integer> getRepository() {
		// TODO Auto-generated method stub
		return feedbackRepository;
	}

	

}
