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

import pe.edu.upc.ticketmaster.model.entity.Gender;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.GenderService;

@Controller
@RequestMapping("/genders")
@SessionAttributes("genderEdit") //Se utiliza para guardar el objeto en memoria
public class GenderController {
	
	@Autowired
	private GenderService genderService;
	
	@GetMapping
	public String listar(Model model) {
		Gender genderSearch=new Gender();
		model.addAttribute("genderSearch",genderSearch);
		try {
			
			//---
			List<Gender> genders = genderService.getAll();
			model.addAttribute("genders", genders);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "genders/lista";
	}
	
	@GetMapping("{id}") //GET: /genders/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			
			Optional<Gender> optional = genderService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("gender", optional.get());
				return "genders/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/genders"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<Gender> optional = genderService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("genderEdit", optional.get());
				return "genders/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/genders"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("genderEdit") Gender gender) {
		
		try {
			Gender genderReturn = genderService.update(gender);
			model.addAttribute("gender",genderReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "genders/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/genders";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		
		try {
			Gender gender = new Gender();
			model.addAttribute("genderNew",gender);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "genders/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/genders"; //url
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("genderNew") Gender gender) {
		
		try {
			Gender genderReturn = genderService.create(gender);
			model.addAttribute("gender",genderReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "genders/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/genders";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<Gender> optional = genderService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				genderService.deleteById(id);
			}
			else {
				return "redirect:/genders";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/genders";
	}

}
