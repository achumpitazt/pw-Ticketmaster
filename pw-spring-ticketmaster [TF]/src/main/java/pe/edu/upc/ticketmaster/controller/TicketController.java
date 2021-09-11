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

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.PaymentOption;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.model.entity.Ticket;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;
import pe.edu.upc.ticketmaster.service.crud.PaymentOptionService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;
import pe.edu.upc.ticketmaster.service.crud.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private PaymentOptionService paymentOptionService;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			List<Ticket> tickets = ticketService.getAll();
			model.addAttribute("tickets", tickets);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "tickets/lista";
	}
	
	@GetMapping("myTickets")
	public String listar2(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			List<Ticket> tickets = ticketService.getAll();
			model.addAttribute("tickets", tickets);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "myTickets/myTickets";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		
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
		return "redirect:/tickets"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Ticket> optional = ticketService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("ticketEdit", optional.get());
				List<PaymentOption> paymentOptions = paymentOptionService.getAll();
				model.addAttribute("paymentOptions",paymentOptions);
				List<Customer> customers = customerService.getAll();
				model.addAttribute("customers",customers);
				List<Show> shows = showService.getAll();
				model.addAttribute("shows",shows);
				return "tickets/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tickets"; //url
	}
	
	
	
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("ticketEdit") Ticket ticket) {
		
		try {
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			Ticket ticketReturn = ticketService.update(ticket);
			model.addAttribute("ticket", ticketReturn);
			return "tickets/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tickets";
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

}
