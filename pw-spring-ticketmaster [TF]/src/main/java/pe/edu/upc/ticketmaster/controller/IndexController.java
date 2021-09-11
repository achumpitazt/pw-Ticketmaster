package pe.edu.upc.ticketmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Show;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String indexGet(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("access-denied")
	public String accessDenied() {
		return "access-denied";
	}

}
