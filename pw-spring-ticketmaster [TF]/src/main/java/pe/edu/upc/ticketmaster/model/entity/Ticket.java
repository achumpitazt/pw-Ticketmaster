package pe.edu.upc.ticketmaster.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tickets")

public class Ticket{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentoption_id", nullable = false)
    private PaymentOption paymentOption;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
    
    @Column(name= "card_owner", length = 200)
    private String cardOwner;
    
    @Column(name= "card_number", length = 16)
    private String cardNumber;
    
    @Column(name= "card_expiration_day", length = 5)
    private String cardExpirationDay;
    
    @Column(name= "cvv", length = 4)
    private String cvv;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(Integer id, PaymentOption paymentOption, Customer customer, Show show, String cardOwner,
			String cardNumber, String cardExpirationDay, String añoVencimientoTarjeta, String cvv) {
		super();
		this.id = id;
		this.paymentOption = paymentOption;
		this.customer = customer;
		this.show = show;
		this.cardOwner = cardOwner;
		this.cardNumber = cardNumber;
		this.cardExpirationDay = cardExpirationDay;
		this.cvv = cvv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentOption getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public String getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpirationDay() {
		return cardExpirationDay;
	}

	public void setCardExpirationDay(String cardExpirationDay) {
		this.cardExpirationDay = cardExpirationDay;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
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
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
   
    
   

    

}