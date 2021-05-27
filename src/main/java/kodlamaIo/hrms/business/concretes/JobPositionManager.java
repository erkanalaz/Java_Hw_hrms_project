package kodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.hrms.business.abstracts.JobPositionService;
import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaIo.hrms.entities.concretes.JobPosition;

import kodlamaIo.hrms.core.utilities.results.*;

@Service
public class JobPositionManager implements JobPositionService  {
	private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

	@Override
	public DataResult<List<JobPosition>> getPositions() {
		return new SuccessDataResult<>(this.jobPositionDao.findAll(), "Success: Pozisyonalar listelendi.");
	}

	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		try {
          this.jobPositionDao.save(jobPosition);
          return new SuccessResult("Success: Pozisyon sisteme eklendi!");
      } catch (Exception e) {
          return new ErrorResult("Error: Sisteme kayıtlı böyle bir pozisyon mevcut!");
      }
}}