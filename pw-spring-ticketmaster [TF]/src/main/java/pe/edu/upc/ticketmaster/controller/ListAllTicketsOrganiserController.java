package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.model.entity.Ticket;
import pe.edu.upc.ticketmaster.service.crud.TicketService;

@Controller
@RequestMapping("/listAllTicketsOrganiser")
public class ListAllTicketsOrganiserController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//-----
		Show ticketbyshowSearch= new Show();
		model.addAttribute("ticketbyshowSearch",ticketbyshowSearch);
		try {
			List<Ticket> tickets = ticketService.getAll();
			model.addAttribute("tickets",tickets);
			List<Ticket> shows = ticketService.getAll();
			model.addAttribute("shows",shows);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "findTicketOrganiserByShow/listTicketsOrganiserByShow";
	}
	
}
