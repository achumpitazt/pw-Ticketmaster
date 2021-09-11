package pe.edu.upc.ticketmaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Feedback;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.FeedbackService;

@Controller
@RequestMapping("/listAllFeedbackOrganiser")
public class ListAllFeedbackOrganiserController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//-----
		Show feedbackbyshowSearch = new Show();
		model.addAttribute("feedbackbyshowSearch",feedbackbyshowSearch);
		try {
			List<Feedback> feedbacks = feedbackService.getAll();
			model.addAttribute("feedbacks",feedbacks);
			List<Feedback> shows = feedbackService.getAll();
			model.addAttribute("shows", shows);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "findFeedbackOrganiserByShow/listFeedbackOrganiserByShow";
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
