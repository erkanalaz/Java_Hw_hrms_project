package kodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaIo.hrms.entities.concretes.JobSeeker;
import kodlamaIo.hrms.core.services.MernisCheckService;
import kodlamaIo.hrms.core.utilities.results.*;
import kodlamaIo.hrms.core.utilities.EmailValidator;

import kodlamaIo.hrms.business.abstracts.JobSeekerService;

@Service
public class JobSeekerManager implements JobSeekerService  {
	 private final JobSeekerDao jobSeekerDao;
	    private final MernisCheckService mernisCheckService;

	    @Autowired
	    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService) {
	        this.jobSeekerDao = jobSeekerDao;
	        this.mernisCheckService = mernisCheckService;
	    }

	    @Override
	    public DataResult<List<JobSeeker>> getJobSeekers() {
	        return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Success: İş Arayanlar listelendi.");
	    }

	    @Override
	    public Result addJobSeeker(JobSeeker jobSeeker) {
	        try {
	            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
	                return new ErrorResult("Error: Mail formata uygun değil!");
	            } else if (!mernisCheckService.isMernis(jobSeeker)) {
	                return new ErrorResult("Error: Gerçek bir kişi değil!");
	            } else {
	                this.jobSeekerDao.save(jobSeeker);
	                return new SuccessResult(
	                        "Success: İş arayan kullanıcı sisteme eklendi, Doğrulama kodu email adresinize gönderildi!");
	            }
	        } catch (Exception e) {
	            if (e.getMessage()
	                 .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
	                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
	            } else {
	                return new ErrorResult(
	                        "Error: Kimlik numarası sistem de kayıtlı, lütfen başka bir kimlik numarası giriniz!");
	            }
	        }
	    }
}
