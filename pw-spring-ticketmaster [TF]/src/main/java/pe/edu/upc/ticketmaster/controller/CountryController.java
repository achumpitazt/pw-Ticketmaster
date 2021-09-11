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

import pe.edu.upc.ticketmaster.model.entity.Country;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.CountryService;

@Controller
@RequestMapping("/countries")
@SessionAttributes("countryEdit")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping
	public String listar(Model model) {
		
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			Country countrySearch=new Country();
			model.addAttribute("countrySearch",countrySearch);
			//---
			List<Country> countries = countryService.getAll();
			model.addAttribute("countries",countries);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "countries/lista";
	}
	
	@GetMapping("{id}") //GET: /genders/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			
			Optional<Country> optional = countryService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("country", optional.get());
				return "countries/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/countries"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Country> optional = countryService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("countryEdit", optional.get());
				return "countries/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/genders"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("countryEdit") Country country) {
		
		try {
			Country countryReturn = countryService.update(country);
			model.addAttribute("country",countryReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "countries/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/countries";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		
		try {
			Country country = new Country();
			model.addAttribute("countryNew",country);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "countries/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/countries"; //url
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("countryNew") Country country) {
		
		try {
			Country countryReturn = countryService.create(country);
			model.addAttribute("country",countryReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "countries/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/countries";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<Country> optional = countryService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				countryService.deleteById(id);
			}
			else {
				return "redirect:/countries";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/countries";
	}
	

}
