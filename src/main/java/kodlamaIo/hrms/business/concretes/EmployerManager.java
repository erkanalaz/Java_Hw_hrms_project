package kodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.hrms.business.abstracts.EmployerService;
import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import kodlamaIo.hrms.core.utilities.results.SuccessResult;
import kodlamaIo.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaIo.hrms.entities.concretes.*;

import kodlamaIo.hrms.core.utilities.EmailValidator;
import kodlamaIo.hrms.core.utilities.results.*;

@Service
public class EmployerManager implements EmployerService {
	
	private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getEmployers() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Success: İş Verenler listelendi.");
    }

    @Override
    public Result addEmployer(Employer employer) {
    	
        String[] employerWebsite = employer.getWebsite().split("www.", 2);
                String website = employerWebsite[1];

        String[] employerEmail = employer.getEmail().split("@");
        String employerDomain = employerEmail[1];
        
        try {
            if (!EmailValidator.emailFormatController(employer.getEmail())) {
                return new ErrorResult("Error: Mail formata uygun değil!");
                
            } else if (!employerDomain.equals(website)) {
                return new ErrorResult("Error: Web sitesi ile email aynı domaine sahip değil!");
                
            } else if (!employer.getPassword().equals(employer.getConfirmPassword())) {
                return new ErrorResult("Error: Girmiş olduğunuz şifreler uyuşmuyor!");
                
            } else {
                this.employerDao.save(employer);
                return new SuccessResult(
                        "Success: İş veren kullanıcı sisteme eklendi, Doğrulama kodu email adresinize gönderildi!");
                
            }
        } catch (Exception e) {
        	
            if (e.getMessage().equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
            } else {
                return new ErrorResult("Error: Şirket adı sistem de kayıtlı, lütfen başka bir Şirket adı giriniz!");
            }
        }
    }

}
