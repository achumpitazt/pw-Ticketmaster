package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Organiser;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.OrganiserService;

@Controller
@RequestMapping("/listAllOrganiserCustomer")
public class ListAllOrganiserCustomer {
	
	@Autowired
	private OrganiserService organiserService;
	
	@GetMapping
	public String listar2(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//----
		Organiser organiserSearch=new Organiser();
		model.addAttribute("organiserSearch",organiserSearch);
		try {
			List<Organiser> organisers = organiserService.getAll();
			model.addAttribute("organisers", organisers);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "organisers/Lista2";
	}
	
}
