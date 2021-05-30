package reflection.hrms.core.utilities.results;

public class Result {

	private String message;
	private boolean success;
	
	
	public Result(boolean success) {
		super();
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
}
