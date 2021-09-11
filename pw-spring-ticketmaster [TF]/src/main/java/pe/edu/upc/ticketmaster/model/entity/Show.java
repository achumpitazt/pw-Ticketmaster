package pe.edu.upc.ticketmaster.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "shows", indexes= {@Index(columnList="show_name", name = "show_index_name" )})
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "show_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "organiser_id",nullable = false)
	private Organiser organiser;
	
	@ManyToOne
	@JoinColumn(name ="eventType_id", nullable = false)
	private EventType eventType;
	
	@NotEmpty(message = "Prueba de error")
	@Column( name = "show_name", length = 200,nullable = false )
	private String name;
	
	@Column(name = "day")
	private Integer day;
	
	@Column(name = "month")
	private Integer month;
	
	@Column(name = "year")
	private Integer year;
	
	@Column( name = "description", length = 500 )
	private String description;
	
	@Column(name = "time", length = 5)
	private String time;
	
	@Column(name = "enlace", length = 500)
	private String enlace;
	
	@Min(1)
	@Max(500)
	@Column(name = "price", columnDefinition = "DECIMAL(5,2)")
	private float price;
	
	@OneToMany(mappedBy = "show",fetch = FetchType.LAZY )
	private List<Feedback> feedbacks;
	
	@OneToMany(mappedBy = "show",fetch = FetchType.LAZY)
	private List<Ticket> tickets;

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Show(Integer id, Organiser organiser, EventType eventType, String name, Integer day, Integer month,
			Integer year, String description, String time, String enlace, float price, List<Feedback> feedbacks,
			List<Ticket> tickets) {
		super();
		this.id = id;
		this.organiser = organiser;
		this.eventType = eventType;
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.description = description;
		this.time = time;
		this.enlace = enlace;
		this.price = price;
		this.feedbacks = feedbacks;
		this.tickets = tickets;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Organiser getOrganiser() {
		return organiser;
	}

	public void setOrganiser(Organiser organiser) {
		this.organiser = organiser;
	}

	public EventType getEventType() {
		return eventType;
	}


	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
		Show other = (Show) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	


	
	

}
