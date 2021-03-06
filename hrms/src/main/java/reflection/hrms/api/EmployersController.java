package reflection.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reflection.hrms.business.abstracts.EmployerService;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.entities.concretes.Employer;
import reflection.hrms.entities.concretes.dtos.RegisterEmployerDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody RegisterEmployerDto employerDto) {
		return this.employerService.add(employerDto);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	
	
	
}
