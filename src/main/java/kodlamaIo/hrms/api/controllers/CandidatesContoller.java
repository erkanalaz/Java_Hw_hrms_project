package kodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.hrms.business.abstracts.CandidateService;
import kodlamaIo.hrms.entities.concretes.Candidate;

@RestController  //sen controllersın.restfull çalışacaksında android de ıos da senden iletişimde bulunabilir.
@RequestMapping("/api/candidates")	///api/products dış dünyadan sana /api/products şeklinde talep gelirse bu controller ı çalıştır

public class CandidatesContoller {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesContoller(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")	//...../getall isteğinde bulunulursa burası çalışacak
	public List<Candidate> getAll(){
		return this.candidateService.getAll();
	}
}
