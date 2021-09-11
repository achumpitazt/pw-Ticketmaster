package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.Feedback;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;
import pe.edu.upc.ticketmaster.service.crud.FeedbackService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Controller
@RequestMapping("/listAllShowCustomer")
public class ListAllShowCustomerController {
	@Autowired
	private ShowService showService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String listar(Model model) {
		try {
			List<Show> shows = showService.getAll();
			model.addAttribute("shows", shows);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "findShowsByName/listShowsUserByName";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		//----
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			Feedback feedback = new Feedback();
			model.addAttribute("feedbackNew", feedback);
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers",customers);
			List<Show> shows = showService.getAll();
			model.addAttribute("shows",shows);
			return "feedbacks/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/feedbacks"; //url
	}
	
	@PostMapping("savenew") //Post: /shows/saves
	public String saveNew(Model model,@ModelAttribute("feedbackNew") Feedback feedback) {
		//----
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			Feedback feedbackReturn = feedbackService.create(feedback);
			model.addAttribute("show",feedbackReturn);
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	
	
	
}
