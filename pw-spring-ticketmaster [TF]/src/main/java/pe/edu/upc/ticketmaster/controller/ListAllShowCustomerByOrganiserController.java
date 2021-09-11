package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Organiser;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Controller
@RequestMapping("/listAllShowCustomerByOrganiser")
public class ListAllShowCustomerByOrganiserController {
	
	@Autowired
	private ShowService showService;
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//----
		Organiser showbyorganiserSearch= new Organiser();
		model.addAttribute("showbyorganiserSearch",showbyorganiserSearch);
		try {
			List<Show> shows = showService.getAll();
			model.addAttribute("shows", shows);
			List<Show> organisers = showService.getAll();
			model.addAttribute("organisers", organisers);
		} catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "findShowsUserByOrganizer/listShowsUserByOrganizer";
	}
	
}
