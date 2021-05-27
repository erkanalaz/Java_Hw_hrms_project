package kodlamaIo.hrms.entities.concretes;
import javax.persistence.*;

@Entity
@Table(name = "job_positions", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_title"})})


public class JobPosition {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_title")
    private String jobTitle;
    
    public JobPosition() {
    	
    }
    
	public JobPosition(int id, String jobTitle) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
    
    
}
