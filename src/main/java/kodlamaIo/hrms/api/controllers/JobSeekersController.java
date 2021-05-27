package kodlamaIo.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaIo.hrms.business.abstracts.JobSeekerService;
import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getjobseekers")
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return this.jobSeekerService.getJobSeekers();
    }

    @PostMapping("/addjobseeker")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }


}