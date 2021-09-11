package pe.edu.upc.ticketmaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.model.entity.Ticket;
import pe.edu.upc.ticketmaster.service.crud.TicketService;

@Controller
@RequestMapping("listAllTicketsCustomer")
public class ListAllTicketsCustomerController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//-----
		Customer ticketbycustomerSearch= new Customer();
		model.addAttribute("ticketbycustomerSearch",ticketbycustomerSearch);
		try {
			List<Ticket> tickets = ticketService.getAll();
			model.addAttribute("tickets",tickets);
			List<Ticket> customers = ticketService.getAll();
			model.addAttribute("customers",customers);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "findTicketsUserByCustomer/listTicketsUserByCustomer";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<Ticket> optional = ticketService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				ticketService.deleteById(id);
			}
			else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/";
	}
	
	@GetMapping("/altview/{id}")
	public String findById3(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Ticket> optional = ticketService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("ticket", optional.get());
				return "myTickets/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/"; //url
	}
	

}
