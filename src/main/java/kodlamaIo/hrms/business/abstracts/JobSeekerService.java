package kodlamaIo.hrms.business.abstracts;

import java.util.List;

import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getJobSeekers();

    Result addJobSeeker(JobSeeker jobSeeker);
}
