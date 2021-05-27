package kodlamaIo.hrms.core.utilities;

import org.springframework.stereotype.Service;

import kodlamaIo.hrms.core.services.MernisCheckService;
import kodlamaIo.hrms.entities.concretes.JobSeeker;

@Service
public class Mernis implements MernisCheckService {

	@Override
	public boolean isMernis(JobSeeker jobSeeker) {
		return jobSeeker.getIdentityNumber().length()==11;
	}

}
