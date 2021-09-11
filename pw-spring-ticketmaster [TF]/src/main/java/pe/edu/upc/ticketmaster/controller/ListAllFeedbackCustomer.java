package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.Feedback;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.FeedbackService;

@Controller
@RequestMapping("/listAllFeedbackCustomer")
public class ListAllFeedbackCustomer {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//-----
		Customer feedbackbycustomerSearch = new Customer();
		model.addAttribute("feedbackbycustomerSearch",feedbackbycustomerSearch);
		try {
			List<Feedback> feedbacks = feedbackService.getAll();
			model.addAttribute("feedbacks",feedbacks);
			List<Feedback> customers = feedbackService.getAll();
			model.addAttribute("customers", customers);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "findFeedbackUserByCustomer/listFeedbacksUserByCustomer";
	}
}
