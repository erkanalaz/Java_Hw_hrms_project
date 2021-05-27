package kodlamaIo.hrms.business.abstracts;

import java.util.List;

import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getEmployers();

    Result addEmployer(Employer employer);
}
