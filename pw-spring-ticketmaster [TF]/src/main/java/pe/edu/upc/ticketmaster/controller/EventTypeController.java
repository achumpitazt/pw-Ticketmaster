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
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.EventTypeService;

@Controller
@RequestMapping("/eventTypes")
@SessionAttributes("eventTypeEdit")
public class EventTypeController {
	
	@Autowired
	private EventTypeService eventTypeService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//----
		EventType eventTypeSearch = new EventType(); 	 	
		model.addAttribute("eventTypeSearch", eventTypeSearch);
		try {
			List<EventType>eventTypes = eventTypeService.getAll();
			model.addAttribute("eventTypes",eventTypes);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "eventTypes/lista";
	}
	
	@GetMapping("{id}") //GET: /genders/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			
			Optional<EventType> optional = eventTypeService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("eventType", optional.get());
				return "eventTypes/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/eventTypes"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<EventType> optional = eventTypeService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("eventTypeEdit", optional.get());
				return "eventTypes/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/eventTypes"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("eventTypeEdit") EventType eventType) {
		
		try {
			EventType eventTypeReturn = eventTypeService.update(eventType);
			model.addAttribute("eventType",eventTypeReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "eventTypes/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/eventTypes";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		
		try {
			EventType eventType = new EventType();
			model.addAttribute("eventTypeNew",eventType);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "eventTypes/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/eventTypes"; //url
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("eventTypeNew") EventType eventType) {
		
		try {
			EventType eventTypeReturn = eventTypeService.create(eventType);
			model.addAttribute("eventType",eventTypeReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "eventTypes/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/eventTypes";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<EventType> optional = eventTypeService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				eventTypeService.deleteById(id);
			}
			else {
				return "redirect:/eventTypes";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/eventTypes";
	}

}
