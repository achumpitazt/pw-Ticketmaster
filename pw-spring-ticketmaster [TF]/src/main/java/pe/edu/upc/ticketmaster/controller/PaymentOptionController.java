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

import pe.edu.upc.ticketmaster.model.entity.PaymentOption;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.PaymentOptionService;

@Controller
@RequestMapping("/paymentOptions")
@SessionAttributes("paymentOptionEdit")
public class PaymentOptionController {
	
	@Autowired
	private PaymentOptionService paymentOptionService;
	
	@GetMapping
	public String listar(Model model) {
		Show showSearch = new Show();
		model.addAttribute("showSearch",showSearch);
		//----
		PaymentOption paymentoptionSearch=new PaymentOption();
		model.addAttribute("paymentoptionSearch",paymentoptionSearch);
		try {
			List<PaymentOption> paymentOptions = paymentOptionService.getAll();
			model.addAttribute("paymentOptions", paymentOptions);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "paymentOptions/lista";
	}
	
	@GetMapping("{id}") //GET: /genders/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		
		try {
			
			Optional<PaymentOption> optional = paymentOptionService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("paymentOption", optional.get());
				return "paymentOptions/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/paymentOptions"; //url
	}
	
	@GetMapping("{id}/edit") //GET: /genders/{id}
	public String findById2(Model model, @PathVariable("id") Integer id) {
		
		try {
			Optional<PaymentOption> optional = paymentOptionService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				model.addAttribute("paymentOptionEdit", optional.get());
				return "paymentOptions/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/paymentOptions"; //url
	}
	
	@PostMapping("save") //Post: /genders/saves
	public String saveEdit(Model model,@ModelAttribute("paymentOptionEdit") PaymentOption paymentOption) {
		
		try {
			PaymentOption paymentOptionReturn = paymentOptionService.update(paymentOption);
			model.addAttribute("paymentOption",paymentOptionReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "paymentOptions/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/paymentOptions";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		
		try {
			PaymentOption paymentOption = new PaymentOption();
			model.addAttribute("paymentOptionNew",paymentOption);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "paymentOptions/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/paymentOptions"; //url
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("paymentOptionNew") PaymentOption paymentOption) {
		
		try {
			PaymentOption paymentOptionReturn = paymentOptionService.create(paymentOption);
			model.addAttribute("paymentOption",paymentOptionReturn);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			return "paymentOptions/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/paymentOptions";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Optional<PaymentOption> optional = paymentOptionService.findById(id);
			//----
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			if(optional.isPresent()) {
				paymentOptionService.deleteById(id);
			}
			else {
				return "redirect:/paymentOptions";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/paymentOptions";
	}

}
