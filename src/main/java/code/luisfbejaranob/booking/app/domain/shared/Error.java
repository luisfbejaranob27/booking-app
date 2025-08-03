package code.luisfbejaranob.booking.app.domain.shared;

public class Error
{
	private final String code;
	private final String message;

	public Error(DomainError error)
	{
		if (error == null) {
			throw new IllegalArgumentException("DomainError cannot be null");
		}
		this.code = error.getCode();
		this.message = error.getMessage();
	}

	public Error(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode()
	{
		return code;
	}

	public String getMessage()
	{
		return message;
	}

	public static final Error None = new Error("Error.None", "No error");
	public static final Error NullValue = new Error("Error.NullValue", "Value is null");
	public static final Error ValidationError = new Error("Error.ValidationError", "Validation failed");
	public static final Error NotFound = new Error("Error.NotFound", "Resource not found");
	public static final Error Unauthorized = new Error("Error.Unauthorized", "Access denied");
	public static final Error Forbidden = new Error("Error.Forbidden", "Access forbidden");
	public static final Error InternalError = new Error("Error.InternalError", "Internal server error");
}
