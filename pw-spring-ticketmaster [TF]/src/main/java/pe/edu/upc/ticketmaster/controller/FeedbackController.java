package pe.edu.upc.ticketmaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.Feedback;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;
import pe.edu.upc.ticketmaster.service.crud.FeedbackService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Controller
@RequestMapping("/feedbacks")
@SessionAttributes("feedbackEdit")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ShowService showService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			List<Feedback>feedbacks = feedbackService.getAll();
			model.addAttribute("feedbacks", feedbacks);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "feedbacks/lista";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Feedback> optional = feedbackService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("feedback", optional.get());
				return "feedbacks/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/shows"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Feedback> optional = feedbackService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("feedbackEdit", optional.get());
				List<Customer> customers = customerService.getAll();
				model.addAttribute("customers",customers);
				List<Show> shows = showService.getAll();
				model.addAttribute("shows",shows);
				return "feedbacks/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/feedbacks"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("feedbackEdit") Feedback feedback) {
		
		try {
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			Feedback feedbackReturn = feedbackService.update(feedback);
			model.addAttribute("feedback", feedbackReturn);
			return "feedbacks/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/feedbacks";
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
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<Feedback> optional = feedbackService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				feedbackService.deleteById(id);
			}
			else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/";
	}

}
