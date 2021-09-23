package in.nit.healthcare.exception;

public class DoctorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException() {

	}

	public DoctorNotFoundException(String message) {
		super(message);
	}

}
