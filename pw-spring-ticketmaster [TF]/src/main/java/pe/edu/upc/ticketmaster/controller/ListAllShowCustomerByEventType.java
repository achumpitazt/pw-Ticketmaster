package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.EventType;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.EventTypeService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Controller
@RequestMapping("/listAllShowCustomerByEventType")
public class ListAllShowCustomerByEventType {
	@Autowired
	private ShowService showService;
	
	@Autowired
	private EventTypeService eventTypeService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//----
		EventType showbyeventtypeSearch= new EventType();
		model.addAttribute("showbyeventtypeSearch",showbyeventtypeSearch);
		try {
			List<EventType> eventTypes = eventTypeService.getAll();
			model.addAttribute("eventTypes",eventTypes);
			List<Show> shows = showService.getAll();
			model.addAttribute("shows", shows);
			List<Show> eventType = showService.getAll();
			model.addAttribute("eventType", eventType);
		} catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "findShowsUserByEventType/listShowsUserByEventType";
	}

}
