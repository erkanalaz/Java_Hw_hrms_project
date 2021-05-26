package kodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.hrms.business.abstracts.CandidateService;
import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
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
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
}
