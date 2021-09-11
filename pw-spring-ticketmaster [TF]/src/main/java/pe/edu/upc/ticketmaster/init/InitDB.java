package pe.edu.upc.ticketmaster.init;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.ticketmaster.model.entity.Customer;
import pe.edu.upc.ticketmaster.model.entity.User;
import pe.edu.upc.ticketmaster.model.repository.CustomerRepository;
import pe.edu.upc.ticketmaster.model.repository.UserRepository;



@Service
public class InitDB implements CommandLineRunner{
	
	
	/*
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	*/
	
	@Override
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		/*
		Customer customerAlessandro = null;
		Customer customerOliver = null;
		
		customerAlessandro = customerRepository.findById(1).get();
		customerOliver = customerRepository.findById(2).get();
		
		User achumpitaz = new User();
		
		achumpitaz.setCustomer(customerAlessandro);
		customerAlessandro.setUser(achumpitaz);
		
		achumpitaz.setId(1);
		achumpitaz.setUsername("achumpitaz");
		achumpitaz.setPassword(bcpe.encode("achumpitaz"));
		achumpitaz.setEnable(true);
		
		User oqueen = new User();
		
		oqueen.setCustomer(customerOliver);
		customerOliver.setUser(oqueen);
		
		oqueen.setId(2);
		oqueen.setUsername("oqueen");
		oqueen.setPassword(bcpe.encode("oqueen"));
		oqueen.setEnable(true);
		
		//ROLE -> Segemento Objetivo
		achumpitaz.addAuthority("ROLE_CUSTOMER");
		oqueen.addAuthority("ROLE_ORGANISER");
		
		//access
		achumpitaz.addAuthority("ACCESS_STANDART");
		oqueen.addAuthority("ACCESS_VIP");
		
		userRepository.save(achumpitaz);
		userRepository.save(oqueen);
		
		
		
		Customer customeradmin = null;
		customeradmin = customerRepository.findById(3).get();
		
		User admin = new User();
		
		admin.setCustomer(customeradmin);
		customeradmin.setUser(admin);
		
		admin.setId(3);
		admin.setUsername("admin");
		admin.setPassword(bcpe.encode("admin"));
		admin.setEnable(true);
		
		admin.addAuthority("ROLE_ADMIN");
		admin.addAuthority("ACCESS_ALL");
		
		userRepository.save(admin);
		
		*/
	}
	
	

}
