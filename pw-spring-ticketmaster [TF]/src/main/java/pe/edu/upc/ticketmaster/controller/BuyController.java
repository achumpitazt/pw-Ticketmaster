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
import pe.edu.upc.ticketmaster.model.entity.PaymentOption;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.model.entity.Ticket;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;
import pe.edu.upc.ticketmaster.service.crud.PaymentOptionService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;
import pe.edu.upc.ticketmaster.service.crud.TicketService;

@Controller
@RequestMapping("/buys")
public class BuyController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PaymentOptionService paymentOptionService;
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		//----
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			
			Ticket ticket = new Ticket();
			model.addAttribute("ticketNew", ticket);
			List<Show> shows = showService.getAll();
			model.addAttribute("shows",shows);
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers",customers);
			List<PaymentOption> paymentOptions = paymentOptionService.getAll();
			model.addAttribute("paymentOptions",paymentOptions);
			return "buys/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/buys"; //url
	}
	
	@PostMapping("savenew") //Post: /shows/saves
	public String saveNew(Model model,@ModelAttribute("ticketNew") Ticket ticket) {
		//----
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			Ticket ticketReturn = ticketService.create(ticket);
			model.addAttribute("show",ticketReturn);
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/buys";
	}
	
	
	

}
