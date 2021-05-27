package kodlamaIo.hrms.entities.concretes;

import javax.persistence.*;


@Entity
@Table(name = "jobseekers_activations")

public class JobSeekerActivation {
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "jobseeker_id")
	    private int jobseekerId;

	    @Column(name = "is_email_confirmed")
	    private boolean isEmail = false;

	    @Column(name = "is_mernis_valid")
	    private boolean isMernis = false;

	    public JobSeekerActivation() {
	    	
	    }
	    
		public JobSeekerActivation(int id, int jobseekerId, boolean isEmail, boolean isMernis) {
			super();
			this.id = id;
			this.jobseekerId = jobseekerId;
			this.isEmail = isEmail;
			this.isMernis = isMernis;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getJobseekerId() {
			return jobseekerId;
		}

		public void setJobseekerId(int jobseekerId) {
			this.jobseekerId = jobseekerId;
		}

		public boolean isEmail() {
			return isEmail;
		}

		public void setEmail(boolean isEmail) {
			this.isEmail = isEmail;
		}

		public boolean isMernis() {
			return isMernis;
		}

		public void setMernis(boolean isMernis) {
			this.isMernis = isMernis;
		}
}
