package kodlamaIo.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaIo.hrms.business.abstracts.*;
import kodlamaIo.hrms.core.utilities.results.DataResult;
import kodlamaIo.hrms.core.utilities.results.Result;
import kodlamaIo.hrms.entities.concretes.*;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getpositions")
    public DataResult<List<JobPosition>> getPositions() {
        return this.jobPositionService.getPositions();
    }

    @PostMapping("/addposition")
    public Result addJobPosition(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.addJobPosition(jobPosition);
    }
}