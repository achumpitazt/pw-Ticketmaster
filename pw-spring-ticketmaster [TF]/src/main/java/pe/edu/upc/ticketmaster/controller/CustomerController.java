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
import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.Gender;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.CountryService;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;
import pe.edu.upc.ticketmaster.service.crud.GenderService;

@Controller
@RequestMapping("/customers")
@SessionAttributes("customerEdit")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//--
		Customer customerSearch=new Customer();
		model.addAttribute("customerSearch",customerSearch);
		
		try {
			List<Customer> customers = customerService.getAll();
			List<Country> countries = countryService.getAll();
			List<Gender> genders = genderService.getAll();
			model.addAttribute("customers",customers);
			model.addAttribute("countries",countries);
			model.addAttribute("genders",genders);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "customers/lista";
	}
	
	@GetMapping("{id}") //GET: /genders/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			
			Optional<Customer> optional = customerService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("customer", optional.get());
				return "customers/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Customer> optional = customerService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("customerEdit", optional.get());
				List<Country> countries = countryService.getAll();
				model.addAttribute("countries",countries);
				List<Gender> genders = genderService.getAll();
				model.addAttribute("genders",genders);
				return "customers/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("customerEdit") Customer customer) {
		
		try {
			Customer customerReturn = customerService.update(customer);
			model.addAttribute("customer",customerReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "customers/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		
		try {
			Customer customer = new Customer();
			model.addAttribute("customerNew",customer);
			List<Country> countries = countryService.getAll();
			model.addAttribute("countries",countries);
			List<Gender> genders = genderService.getAll();
			model.addAttribute("genders",genders);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "customers/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers"; //url
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("customerNew") Customer customer) {
		
		try {
			Customer customerReturn = customerService.create(customer);
			model.addAttribute("customer",customerReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "customers/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<Customer> optional = customerService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				customerService.deleteById(id);
			}
			else {
				return "redirect:/customers";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/customers";
	}
	

}
