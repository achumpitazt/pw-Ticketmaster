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

import pe.edu.upc.ticketmaster.model.entity.EventType;
import pe.edu.upc.ticketmaster.model.entity.Organiser;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.EventTypeService;
import pe.edu.upc.ticketmaster.service.crud.OrganiserService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Controller
@RequestMapping("/shows")
@SessionAttributes("showEdit")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private OrganiserService organiserService;
	
	@Autowired
	private EventTypeService eventTypeService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			List<Show> shows = showService.getAll();
			model.addAttribute("shows", shows);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "shows/lista";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Show> optional = showService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("show", optional.get());
				return "shows/view";
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
			Optional<Show> optional = showService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("showEdit", optional.get());
				List<Organiser> organisers = organiserService.getAll();
				model.addAttribute("organisers",organisers);
				List<EventType> eventTypes = eventTypeService.getAll();
				model.addAttribute("eventTypes",eventTypes);
				return "shows/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/shows"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("showEdit") Show show) {
		
		try {
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			Show showReturn = showService.update(show);
			model.addAttribute("show", showReturn);
			return "shows/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/shows";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		//----
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			Show show = new Show();
			model.addAttribute("showNew", show);
			List<Organiser> organisers = organiserService.getAll();
			model.addAttribute("organisers",organisers);
			List<EventType> eventTypes = eventTypeService.getAll();
			model.addAttribute("eventTypes",eventTypes);
			return "shows/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/shows"; //url
	}
	
	@PostMapping("savenew") //Post: /shows/saves
	public String saveNew(Model model,@ModelAttribute("showNew") Show show) {
		//----
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		try {
			Show showReturn = showService.create(show);
			model.addAttribute("show",showReturn);
			return "redirect:/shows";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/shows";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<Show> optional = showService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				showService.deleteById(id);
			}
			else {
				return "redirect:/shows";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/shows";
	}

}
