package ${groupId}.domain.common;

import java.util.ArrayList;
import java.util.List;

public class Result {

	private String status;
	private List<Error> errors;
	
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [status=" + status + ", errors=" + errors + "]";
	}

	public Result(String status, List<Error> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errors
	 */
	public List<Error> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public void addError(Error error) {
		
		if (errors == null) {
			errors = new ArrayList<Error>();
		}
		errors.add(error);
	}
}
