package pe.edu.upc.ticketmaster.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PaymentOptions")
//@SequenceGenerator(name = "PaymentOptions_payment_option_id_seq", initialValue = 1,allocationSize = 1)
public class PaymentOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_option_id")
    private Integer id;

    @Column(name = "name",length = 500 )
    private String name;

    @Column(name = "description",length = 500)
    private String description;
    
    @OneToMany(mappedBy = "paymentOption")
	private List<Ticket> tickets;
    
    public PaymentOption() {
		super();
		// TODO Auto-generated constructor stub
	}

    public PaymentOption(Integer id, String name, String description, List<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tickets = tickets;
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		PaymentOption other = (PaymentOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   	
   	
    
   
	
}