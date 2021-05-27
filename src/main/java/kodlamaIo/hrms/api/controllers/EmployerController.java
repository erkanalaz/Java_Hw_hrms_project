package kodlamaIo.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.hrms.business.abstracts.EmployerService;
import kodlamaIo.hrms.entities.concretes.Employer;
import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getemployers")
    public DataResult<List<Employer>> getEmployers() {
        return this.employerService.getEmployers();
    }

    @PostMapping("/addemployer")
    public Result addEmployer(@RequestBody Employer employer) {
        return this.employerService.addEmployer(employer);
    }
}

