package kodlamaIo.hrms.entities.concretes;

import javax.persistence.*;


@Entity
@Table(name = "system_personels", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})


public class SystemPersonel extends User {
	 	@Column(name = "personel_id")
	    private int id;

	    @Column(name = "username")
	    private String username;

	    public SystemPersonel() {
	    	
	    }
	    
		public SystemPersonel(int id, String username) {
			super();
			this.id = id;
			this.username = username;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
}
