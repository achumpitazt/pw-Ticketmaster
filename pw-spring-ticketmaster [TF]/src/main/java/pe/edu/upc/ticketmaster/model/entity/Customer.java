package pe.edu.upc.ticketmaster.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "Customers",
		uniqueConstraints = {@UniqueConstraint(columnNames= {"email"})})
//@SequenceGenerator(name = "Customer_customers_id_seq", initialValue = 1, allocationSize = 1)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	
	@NotEmpty(message = "Prueba de error")
	@Column( name = "first_name", length = 100 , nullable = false)
	private String firstname;
	
	@Column( name = "last_name", length = 100 )
	private String lastname;
	
	@Column( name = "email", length = 100 )
	private String email;
	
	@Column( name = "password", length = 100 )
	private String password;
	
	@ManyToOne
	@JoinColumn(name= "country_id", nullable = false)
	private Country country;
	
	@ManyToOne
	@JoinColumn(name= "gender_id", nullable = false)
	private Gender gender;
	
	@OneToMany(mappedBy = "customer")
	private List<Feedback>feedbacks;
	
	@OneToMany(mappedBy = "customer")
	private List<Ticket> tickets;
	
	@OneToOne(mappedBy = "customer")
	private User user;

	

	public Customer() {
		super();
	}

	
	
	public Customer(Integer id, String firstname, String lastname, String email, String password, Country country,
			Gender gender, List<Feedback> feedbacks, List<Ticket> tickets, User user) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.country = country;
		this.gender = gender;
		this.feedbacks = feedbacks;
		this.tickets = tickets;
		this.user = user;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
