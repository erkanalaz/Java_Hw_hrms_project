package kodlamaIo.hrms.business.abstracts;

import java.util.List;

import kodlamaIo.hrms.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate> getAll();
}
