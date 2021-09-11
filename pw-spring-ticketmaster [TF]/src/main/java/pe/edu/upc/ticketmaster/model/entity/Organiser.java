package pe.edu.upc.ticketmaster.model.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Organisers", indexes = {@Index(columnList="organiser_name", name = "organiser_index_name")})

public class Organiser {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="organiser_id")
	    private Integer id;

	    @Column(name = "organiser_name",length = 100)
	    private String name;

	    @Column(name="email",length = 500)
	    private String email;

	    @Column(name="password",length = 30)
	    private String password;
	    
	    @Column(name="description",length = 300)
	    private String description;
	    
	      
	    @OneToMany(mappedBy = "organiser")
		private List<Show> shows;
	    
	    
		public Organiser() {
			super();
			
		}

		


		public Organiser(Integer id, String name, String email, String password, String description,
				List<Show> shows) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.description = description;
			
			this.shows = shows;
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




		public String getDescription() {
			return description;
		}




		public void setDescription(String description) {
			this.description = description;
		}




		public List<Show> getShows() {
			return shows;
		}




		public void setShows(List<Show> shows) {
			this.shows = shows;
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
			Organiser other = (Organiser) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		

		
		
	    
	    
}
