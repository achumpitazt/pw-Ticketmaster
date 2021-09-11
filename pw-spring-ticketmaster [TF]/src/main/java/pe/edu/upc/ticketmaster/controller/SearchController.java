	package pe.edu.upc.ticketmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ticketmaster.model.entity.Country;
import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.EventType;
import pe.edu.upc.ticketmaster.model.entity.Gender;
import pe.edu.upc.ticketmaster.model.entity.Organiser;
import pe.edu.upc.ticketmaster.model.entity.PaymentOption;
import pe.edu.upc.ticketmaster.model.entity.Show;
import pe.edu.upc.ticketmaster.service.crud.CountryService;
import pe.edu.upc.ticketmaster.service.crud.CustomerService;
import pe.edu.upc.ticketmaster.service.crud.EventTypeService;
import pe.edu.upc.ticketmaster.service.crud.GenderService;
import pe.edu.upc.ticketmaster.service.crud.OrganiserService;
import pe.edu.upc.ticketmaster.service.crud.PaymentOptionService;
import pe.edu.upc.ticketmaster.service.crud.ShowService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private OrganiserService organiserService;
	
	@Autowired
	private PaymentOptionService paymentoptionService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EventTypeService eventTypeService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private GenderService genderService;
	
	@GetMapping("customer/shows")
	public String searchShowGet(Model model, @ModelAttribute("showSearch") Show showSearch) {
		System.out.println(showSearch.getName());
		try {
			List<Show> showsFound = showService.findByNameStartingWith(showSearch.getName());
			model.addAttribute("showsFound",showsFound);
			model.addAttribute("showSearch",showSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/shows-result";
	}
	
	//TODO ADMIN/SHOWS 
	
	@GetMapping("admin/organisers")
	public String searchOrganiserGet(Model model,@ModelAttribute("organiserSearch") Organiser organiserSearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Organiser>organisersFound=organiserService.findByNameStartingWith(organiserSearch.getName());
			model.addAttribute("organisersFound",organisersFound);
			model.addAttribute("organiserSearch",organiserSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/organisers-result";
	}
	
	@GetMapping("admin/countries")
	public String searchCountryGet(Model model,@ModelAttribute("countrySearch") Country countrySearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Country>countriesFound=countryService.findByNameStartingWith(countrySearch.getName());
			model.addAttribute("countriesFound",countriesFound);
			model.addAttribute("countrySearch",countrySearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/countries-result";
	}
	
	@GetMapping("admin/genders")
	public String searchGenderGet(Model model,@ModelAttribute("genderSearch") Gender genderSearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Gender>gendersFound=genderService.findByNameStartingWith(genderSearch.getName());
			model.addAttribute("gendersFound",gendersFound);
			model.addAttribute("genderSearch",genderSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/genders-result";
	}
	
	@GetMapping("organiser/showsAll")
	public String searchShowsOrganiserGet(Model model,@ModelAttribute("showSearch") Show showSearch) {
		
		try {
			List<Show> showsFound = showService.findByNameStartingWith(showSearch.getName());
			model.addAttribute("showsFound",showsFound);
			model.addAttribute("showSearch",showSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/showsOrganiser-result";
	}
	
	@GetMapping("customer/organisers2")
	public String searchOrganiserGet2(Model model,@ModelAttribute("organiserSearch") Organiser organiserSearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Organiser>organisersFound=organiserService.findByNameStartingWith(organiserSearch.getName());
			model.addAttribute("organisersFound",organisersFound);
			model.addAttribute("organiserSearch",organiserSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/organisers-result2";
	}
	
	@GetMapping("admin/paymentoptions")
	public String searchPaymentoptionGet(Model model,@ModelAttribute("paymentoptionSearch") PaymentOption paymentoptionSearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			
			List<PaymentOption>paymentoptionsFound=paymentoptionService.findByNameStartingWith(paymentoptionSearch.getName());
			model.addAttribute("paymentoptionsFound",paymentoptionsFound);
			model.addAttribute("paymentoptionSearch",paymentoptionSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/paymentoptions-result";
	}
	
	
	@GetMapping("admin/customers")
	public String searchCustomerGet(Model model,@ModelAttribute("customerSearch") Customer customerSearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			
			List<Customer>customersFound=customerService.findByFirstnameStartingWith(customerSearch.getFirstname());
			model.addAttribute("customersFound",customersFound);
			model.addAttribute("customerSearch",customerSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/customers-result";
	}
	
	@GetMapping("admin/eventTypes")
	public String searchEventTypeGet(Model model,@ModelAttribute("eventTypeSearch") EventType eventTypeSearch) {
		try {
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<EventType> eventTypesFound = eventTypeService.findByNameStartingWith(eventTypeSearch.getName());
			model.addAttribute("eventTypesFound", eventTypesFound);
			model.addAttribute("eventTypeSearch", eventTypeSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/eventTypes-result";
	}
	
	@GetMapping("customer/showsByorganisers")
	public String searchShowByOrganisersGet(Model model,@ModelAttribute("showbyorganiserSearch") Organiser showbyorganiserSearch) {
		try {
	
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Organiser>organisersFound=organiserService.findByNameStartingWith(showbyorganiserSearch.getName());
			model.addAttribute("showbyorganiserFound",organisersFound);
			model.addAttribute("showbyorganiserSearch",showbyorganiserSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/shosw-by-organisers-result";
	}
	
	@GetMapping("customer/showsByeventType")
	public String searchShowByEventTypeGet(Model model,@ModelAttribute("showbyeventTypeSearch") EventType showbyeventtypeSearch) {
		try {
	
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<EventType>eventTypesFound=eventTypeService.findByNameStartingWith(showbyeventtypeSearch.getName());
			model.addAttribute("showbyeventtypeFound",eventTypesFound);
			model.addAttribute("showbyeventtypeSearch",showbyeventtypeSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/shows-by-eventType";
	}
	
	@GetMapping("customer/ticketsBycustomers")
	public String searchTicketByCustomersGet(Model model,@ModelAttribute("ticketbycustomerSearch") Customer ticketbycustomerSearch) {
		try {
	
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Customer>customersFound=customerService.findByFirstnameStartingWith(ticketbycustomerSearch.getFirstname());
			model.addAttribute("ticketbycustomerFound",customersFound);
			model.addAttribute("ticketbycustomerSearch",ticketbycustomerSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/tickets-by-customers";
	}
	
	@GetMapping("customer/feedbacksBycustomers")
	public String searchFeedbackByCustomersGet(Model model,@ModelAttribute("feedbackbycustomerSearch") Customer feedbackbycustomerSearch) {
		try {
	
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			//----
			List<Customer>customersFound=customerService.findByFirstnameStartingWith(feedbackbycustomerSearch.getFirstname());
			model.addAttribute("feedbackbycustomerFound",customersFound);
			model.addAttribute("feedbackbycustomerSearch",feedbackbycustomerSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/feedbacks-by-customers";
	}
	
	@GetMapping("organiser/feedbacksByshows")
	public String searchFeedbackByShowsGet(Model model,@ModelAttribute("feedbackbyshowSearch") Show feedbackbyshowSearch) {
		try {
	
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			//----
			List<Show>showsFound=showService.findByNameStartingWith(feedbackbyshowSearch.getName());
			model.addAttribute("feedbackbyshowFound",showsFound);
			model.addAttribute("feedbackbyshowSearch",feedbackbyshowSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/feedbacks-by-shows";
	}
	
	@GetMapping("organiser/ticketsByshows")
	public String searchTicketByShowsGet(Model model,@ModelAttribute("ticketbyshowSearch") Show ticketbyshowSearch) {
		try {
	
			Show showSearch = new Show();
			model.addAttribute("showSearch",showSearch);
			List<Show>showsFound=showService.findByNameStartingWith(ticketbyshowSearch.getName());
			model.addAttribute("ticketbyshowFound",showsFound);
			model.addAttribute("ticketbycustomerSearch",ticketbyshowSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/tickets-by-show";
	}
	
}
