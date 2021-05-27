package kodlamaIo.hrms.business.abstracts;

import java.util.List;

import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.entities.concretes.JobPosition;


public interface JobPositionService {
	DataResult<List<JobPosition>> getPositions();

    Result addJobPosition(JobPosition jobPosition);
}
