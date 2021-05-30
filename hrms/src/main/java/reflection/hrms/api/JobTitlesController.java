package reflection.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reflection.hrms.business.abstracts.JobTitleService;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;

	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<JobTitle> getById(int id) {
		return this.jobTitleService.getById(id);
	}
	
	@GetMapping("getbytitle")
	public DataResult<JobTitle> getByTitle(String title) {
		return this.jobTitleService.getByTitle(title);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody  JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
}
