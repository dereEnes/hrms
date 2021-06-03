package reflection.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reflection.hrms.business.abstracts.JobAdversisementService;
import reflection.hrms.core.utilities.results.DataResult;
import reflection.hrms.core.utilities.results.Result;
import reflection.hrms.dataAccess.abstracts.JobAdvertisementDao;
import reflection.hrms.entities.concretes.JobAdvertisement;
import reflection.hrms.entities.concretes.dtos.JobAdvertisementDto;
import reflection.hrms.entities.concretes.dtos.JobAdvertsSmall;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdversisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdversisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}
	
	@GetMapping("getByActiveIsTrue")
	public DataResult<List<JobAdvertsSmall>> getByIsActiveIsTrue(@RequestParam int page, @RequestParam int size){
		return this.jobAdvertisementService.getByIsActiveIsTrue(page, size);
	}
	
	@GetMapping("getByActiveIsTrue")
	public DataResult<List<JobAdvertsSmall>> getByEmployerIdIs(@RequestParam int id,@RequestParam int page, @RequestParam int size){
		return this.jobAdvertisementService.getByEmployerIdIs(id, page, size);
	}
	
	@GetMapping("getByActiveIsTrue")
	public DataResult<List<JobAdvertsSmall>> getByIsActiveTrueAndAsc(@RequestParam int page, @RequestParam int size){
		return this.jobAdvertisementService.getByIsActiveTrueAndAsc(page, size);
	}
	
	@GetMapping("/disableAdvertisementById")
	public Result disableAdvertisementById(@RequestParam int id) {
		return this.jobAdvertisementService.disableAdvertisement(id);
	}
	
	
}
